package alex;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationAttributes;

/**
 * default description.
 *
 * @author qct
 * @date 2018/3/20
 * @since 1.0
 */
public class ExampleConfigPostProcessor implements BeanPostProcessor {

    private final AnnotationAttributes annotationAttributes;

    public ExampleConfigPostProcessor(AnnotationAttributes annotationAttributes) {
        this.annotationAttributes = annotationAttributes;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ExampleConfig) {
            ExampleConfig exampleConfig = (ExampleConfig) bean;
            String[] values = annotationAttributes.getStringArray("value");
            int order = annotationAttributes.getNumber("order");
            exampleConfig.setOrder(order);
            exampleConfig.setName(String.join(",", values));
        }
        return bean;
    }
}
