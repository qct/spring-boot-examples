package alex.quartz;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.InterruptableJob;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.quartz.SchedulerException;
import org.quartz.UnableToInterruptJobException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * default description.
 *
 * @author qct
 * @date 2018/3/12
 * @since 1.0
 */
@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class MyJob extends QuartzJobBean implements InterruptableJob {

    private static final Logger logger = LoggerFactory.getLogger(MyJob.class);

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            logger.info("I'm running, {}, {}", jobExecutionContext.getJobDetail().getKey(),
                jobExecutionContext.getScheduler().getSchedulerInstanceId());
            JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
            if (jobDataMap.size() > 0) {
                int anInt = jobDataMap.getInt("alert.times");
                jobDataMap.put("alert.times", ++anInt);
                logger.info("has alerted {} times", anInt);
            } else {
                jobDataMap.put("alert.times", 1);
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(15000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //        logger.info("finished, {}, {}", jobExecutionContext.getJobDetail().getKey(), jobExecutionContext.getFireInstanceId());
    }

    @Override
    public void interrupt() throws UnableToInterruptJobException {
        logger.info("I'm interrupted");
    }
}
