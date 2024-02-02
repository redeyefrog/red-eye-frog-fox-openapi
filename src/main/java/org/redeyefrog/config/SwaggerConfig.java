package org.redeyefrog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableOpenApi
@Configuration
public class SwaggerConfig {

    @Bean
    Docket allDocket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(allApiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .groupName("All");
    }

    @Bean
    Docket customerDocket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(customerApiInfo())
                .select()
                .paths(PathSelectors.ant("/customer/**"))
                .build()
                .groupName("Customer");
    }

    private ApiInfo allApiInfo() {
        Contact contact = new Contact("RedEye Frog", "https://github.com/redeyefrog", "redeyefrog@contact.org");
        return new ApiInfoBuilder()
                .title("Red Eye Frog")
                .description("This is Frog API")
                .version("v1.0")
                .contact(contact)
                .build();
    }

    private ApiInfo customerApiInfo() {
        return new ApiInfoBuilder()
                .title("Customer")
                .description("Customer API")
                .version("v1.0")
                .build();
    }

}
