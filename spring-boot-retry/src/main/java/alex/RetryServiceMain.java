package alex;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.stats.DefaultStatisticsRepository;
import org.springframework.retry.stats.StatisticsListener;
import org.springframework.retry.support.RetryTemplate;

/** Created by quchentao on 2017/3/16. */
@Configuration
@EnableRetry
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class RetryServiceMain {
    @Bean
    public RetryService retryService() {
        return new RetryService();
    }

    public static void main(String[] args) throws Throwable {
        final AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(RetryServiceMain.class);
        final RetryService retryService = applicationContext.getBean(RetryService.class);

        RetryTemplate template = new RetryTemplate();
        template.setRetryPolicy(new SimpleRetryPolicy());
        template.setBackOffPolicy(new FixedBackOffPolicy());
        template.registerListener(new StatisticsListener(new DefaultStatisticsRepository()));

        Object execute =
                template.execute(
                        new RetryCallback<Integer, Exception>() {
                            int i = 5;

                            @Override
                            public Integer doWithRetry(RetryContext context) throws Exception {
                                throw new Exception();
                            }
                        });

        //        String result = retryService.someService();
        //        System.out.println(result);
    }
}
