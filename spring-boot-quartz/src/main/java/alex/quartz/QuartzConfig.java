package alex.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.DateBuilder;
import org.quartz.DateBuilder.IntervalUnit;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.SchedulerListener;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
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
 * @author damon.q
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
                String jobName = "my-job";
                JobDetail detail = JobBuilder
                    .newJob(MyJob.class)
                    .storeDurably()
                    .withIdentity(jobName, jobGroup)
                    .build();

                String triggerName = "my-trigger";
                String triggerGroup = "my-trigger-group";
                String cronEx = "*/6 * * * * ?";
                CronTrigger trigger = TriggerBuilder
                    .newTrigger()
                    .withIdentity(triggerName, triggerGroup)
                    .forJob(detail)
                    .withSchedule(
                        CronScheduleBuilder.cronSchedule(cronEx).withMisfireHandlingInstructionDoNothing())
                    .startAt(DateBuilder.futureDate(3, IntervalUnit.SECOND))
                    .build();
                try {
                    schedulerFactoryBean.getScheduler().getCurrentlyExecutingJobs().forEach(j -> {
                        try {
                            logger.info(j.getScheduler().getSchedulerInstanceId());
                        } catch (SchedulerException e) {
                            e.printStackTrace();
                        }
                    });
                    schedulerFactoryBean.getScheduler().scheduleJob(detail, trigger);
                } catch (SchedulerException e) {
                    logger.error("Schedule job error, {}", detail);
                    e.printStackTrace();
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

            //TODO some monitor code
        };
    }
}
