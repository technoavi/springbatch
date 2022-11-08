package com.technoavi.fisheriz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;

import java.util.Collections;


//@EnableSwagger2
@Configuration
public class SwaggerConfig {

    public static final String DEFAULT_HANDLER_PACKAGE 	= "com.technoavi.fisheriz.controllers";	//what to expose by Swagger
    public static final String DEFAULT_API_PATH_PATTERN = "/fm/.*";		//the path pattern too to expose

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(DEFAULT_HANDLER_PACKAGE))
                .paths(PathSelectors.regex(DEFAULT_API_PATH_PATTERN))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Fisheriz Rest APIs",
                "APIs for Fisheriz.",
                "1.0",
                "Terms of service",
                null,
                "License of API",
                "API license URL",
                Collections.emptyList());
    }
    @Bean
    UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder()
                .deepLinking(true)
                .displayOperationId(false)
                .defaultModelsExpandDepth(1)
                .defaultModelExpandDepth(1)
                .defaultModelRendering(ModelRendering.EXAMPLE)
                .displayRequestDuration(false)
                .docExpansion(DocExpansion.NONE)
                .filter(false)
                .maxDisplayedTags(null)
                .operationsSorter(OperationsSorter.ALPHA)
                .showExtensions(false)
                .tagsSorter(TagsSorter.ALPHA)
                .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
                .validatorUrl(null)
                .build();
    }
}