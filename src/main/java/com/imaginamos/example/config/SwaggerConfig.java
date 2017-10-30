package com.imaginamos.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api-imaginacion")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/private.*"))
                .build();
    }
	
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Imaginacion REST Services")
                .description("Servicios Restful Imaginacion Backend")
                .termsOfServiceUrl("http://en.wikipedia.org/wiki/Terms_of_service")
                .contact("info@imaginacion.com")
                .license("Apache License Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("2.0")
                .build();
    }
}
