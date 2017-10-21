package alex;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Alex on 2016/12/27.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            //.paths(PathSelectors.regex("/api/.*"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo())
//            .useDefaultResponseMessages(false)
//            .globalResponseMessage(RequestMethod.GET, Lists.newArrayList(
//                new ResponseMessageBuilder()
//                    .code(500)
//                    .message("500 message")
//                    .responseModel(new ModelRef("Error"))
//                    .build(),
//                new ResponseMessageBuilder()
//                    .code(403)
//                    .message("Forbidden!")
//                    .build()))
            ;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Spring MVC Demo")
            .description("Spring MVC 简单示例")
            .termsOfServiceUrl("开发者：Damon")
            .contact(new Contact("damon", "http://www.google.com", "xxx@yyy.com"))
            .license("MIT License")
            .licenseUrl("/LICENSE")
            .build();
    }
}
