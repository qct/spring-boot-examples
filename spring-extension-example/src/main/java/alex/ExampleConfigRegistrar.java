package alex;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

/**
 * default description.
 *
 * @author qct
 * @date 2018/3/20
 * @since 1.0
 */
public class ExampleConfigRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(
                importingClassMetadata.getAnnotationAttributes(EnableExampleConfig.class.getName()));

        String beanName = "exampleConfig";
        register(registry, beanName);
        registerBeanPostProcessor(beanName, registry, annotationAttributes);
    }

    private void registerBeanPostProcessor(
            String beanName, BeanDefinitionRegistry registry, AnnotationAttributes annotationAttributes) {
        BeanDefinitionBuilder beanDefinitionBuilder =
                BeanDefinitionBuilder.genericBeanDefinition(ExampleConfigPostProcessor.class);
        beanDefinitionBuilder.addConstructorArgValue(annotationAttributes);
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
        BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, registry);
    }

    private void register(BeanDefinitionRegistry registry, String beanName) {
        if (!registry.containsBeanDefinition(beanName)) {
            // registry.registerBeanDefinition(beanName,
            //    BeanDefinitionBuilder.rootBeanDefinition(ExampleConfig.class).getBeanDefinition());
            registry.registerBeanDefinition(
                    beanName,
                    BeanDefinitionBuilder.genericBeanDefinition(ExampleConfig.class)
                            .getBeanDefinition());
        }
    }
}
