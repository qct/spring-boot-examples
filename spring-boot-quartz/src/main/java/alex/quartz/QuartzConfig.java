package alex.quartz;

import java.util.Collections;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.DateBuilder;
import org.quartz.DateBuilder.IntervalUnit;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.ObjectAlreadyExistsException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerListener;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.listeners.SchedulerListenerSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.quartz.SchedulerFactoryBeanCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * default description.
 *
 * @author qct
 * @date 2018/3/12
 * @since 1.0
 */
@Configuration
public class QuartzConfig {

    private static final Logger logger = LoggerFactory.getLogger(QuartzConfig.class);

    @Value("${spring.quartz.properties.org.quartz.scheduler.instanceName}")
    private String schedulerName;

    @Bean
    public SchedulerFactoryBeanCustomizer customizer() {
        return schedulerFactoryBean -> {
            schedulerFactoryBean.setOverwriteExistingJobs(true);
            schedulerFactoryBean.setSchedulerName(schedulerName);
            schedulerFactoryBean.setSchedulerListeners(schedulerListener(schedulerFactoryBean));
        };
    }

    private SchedulerListener schedulerListener(SchedulerFactoryBean schedulerFactoryBean) {
        return new SchedulerListenerSupport() {
            @Override
            public void schedulerStarted() {
                String jobGroup = "my-job-group";
                String triggerGroup = "my-trigger-group";
                Scheduler scheduler = schedulerFactoryBean.getScheduler();
                try {
                    scheduler.getJobKeys(GroupMatcher.anyJobGroup()).forEach(jobKey -> {
                        try {
                            scheduler.deleteJob(jobKey);
                            logger.info("deleting job: {}", jobKey);
                        } catch (SchedulerException e) {
                            e.printStackTrace();
                        }
                    });
                } catch (SchedulerException e) {
                    e.printStackTrace();
                }

                for (int i = 0; i < 5; i++) {
                    String jobName = "my-job-" + i;
                    JobDetail detail = JobBuilder.newJob(MyJob.class)
                            .withIdentity(jobName, jobGroup)
                            .build();

                    String triggerName = "my-trigger-" + i;
                    String cronEx = "*/20 * * * * ?";
                    CronTrigger trigger = TriggerBuilder.newTrigger()
                            .withIdentity(triggerName, triggerGroup)
                            .forJob(detail)
                            .withSchedule(
                                    CronScheduleBuilder.cronSchedule(cronEx).withMisfireHandlingInstructionDoNothing())
                            .startAt(DateBuilder.futureDate(3, IntervalUnit.SECOND))
                            .build();

                    try {
                        scheduler.scheduleJob(detail, Collections.singleton(trigger), true);
                    } catch (ObjectAlreadyExistsException ex) {
                        logger.warn(
                                "Unexpectedly found existing job, due to cluster race condition: {} Will reschedule"
                                        + " job, can safely be ignored",
                                ex.getMessage());
                        try {
                            scheduler.rescheduleJob(trigger.getKey(), trigger);
                        } catch (SchedulerException e) {
                            logger.error("rescheduleJob job error, {}", detail);
                            logger.error("", e);
                        }
                    } catch (SchedulerException e) {
                        logger.error("Schedule job error, {}", detail);
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void jobAdded(JobDetail jobDetail) {
                logger.debug("Job added: {}", jobDetail);
            }

            @Override
            public void jobScheduled(Trigger trigger) {
                logger.debug("Job Scheduled: {}", trigger);
            }

            // TODO some monitor code
        };
    }
}
