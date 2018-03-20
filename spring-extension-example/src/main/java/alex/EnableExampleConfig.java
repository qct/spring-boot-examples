package alex;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;

/**
 * default description.
 *
 * @author qct
 * @date 2018/3/20
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(ExampleConfigRegistrar.class)
public @interface EnableExampleConfig {

    String[] value() default {"example default value"};

    int order() default Ordered.LOWEST_PRECEDENCE;
}
