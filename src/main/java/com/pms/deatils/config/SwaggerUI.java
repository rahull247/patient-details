package com.pms.deatils.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerUI {

	
	@Bean
	public Docket swagger() {
		return new Docket(DocumentationType.SWAGGER_2)
				 .select()
				 .apis(RequestHandlerSelectors.any())
				 .paths(PathSelectors.any())
				 .build()
				 .apiInfo(apiInfo());
	}
	
	
	private ApiInfo apiInfo() {
        Contact rahul_lokhande = new Contact("Rahul Lokahnde", "", "Rahul.Lokhande@citiustech.com");
        return new ApiInfoBuilder()
                .title("Title: PMS Resource API Enpoints")
                .version("v1.0")
                .description("Desc: API for managing persons details")
                .contact(rahul_lokhande)
                .license("Educational Licence Version 1.0")
                .build();
    }
}
