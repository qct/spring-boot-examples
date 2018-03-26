package alex.quartz;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
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
public class MyJob extends QuartzJobBean {

    private static final Logger logger = LoggerFactory.getLogger(MyJob.class);

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
        logger.info("I'm running, {}, {}", jobExecutionContext.getJobDetail().getKey(),
            jobExecutionContext.getScheduler().getSchedulerInstanceId());
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        logger.info("finished, {}, {}", jobExecutionContext.getJobDetail().getKey(), jobExecutionContext.getFireInstanceId());
    }
}
