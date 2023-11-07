package alex;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/** Created by qct.q on 2017/11/29. */
@Component
public class MyCustomBean
        implements InitializingBean, DisposableBean, BeanFactoryPostProcessor, BeanPostProcessor, Ordered {

    @Override
    public void destroy() throws Exception {
        System.out.println("I'm destroyed");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("I'm initialing");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.getBeanNamesIterator();
        Object bean = beanFactory.getBean("&myFactoryBean");
        System.out.println("postProcessBeanFactory");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        //        System.out.println("Bean '" + beanName + "' created : " + bean.toString());
        return bean;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
