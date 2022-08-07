package com.example.obrestdatajpaej456.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;


@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetail())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetail(){
        return new ApiInfo(
                "Spring Boot",
                "Spring boot api rest Open Bootcamp",
                "1.0",
                "http://google.com",
                new Contact("Pole", "http://google.com", "pole@gmail.com"),
                "gnu",
                "http://google.com",
                Collections.emptyList()
        );
    }
}
