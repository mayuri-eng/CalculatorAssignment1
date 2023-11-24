package com.bnt;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	public Docket SwaggerApi() { 
		 return new Docket(DocumentationType.SWAGGER_2)
		 .select()
         .paths(PathSelectors.ant("calculatorapi/v1/"))
         .apis(RequestHandlerSelectors.basePackage("com.bnt.controller"))
         .build();
	   }
}

