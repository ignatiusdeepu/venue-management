package com.netinsight.scheduall.venue.management.config;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@SuppressWarnings("rawtypes")
public class SwaggerConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	@Bean
	public Docket api() {
		final Parameter autherizationParam = new ParameterBuilder().name("Authorization")
				.description("Enter Bearer token here").modelRef(new ModelRef("string")).parameterType("header")
				.required(false).build();
		Parameter headerParam = new ParameterBuilder().name("Content-Type").modelRef(new ModelRef("string")).parameterType("header").required(true).defaultValue(MediaType.APPLICATION_JSON_VALUE).build();
        
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).paths(Predicates.not(PathSelectors.regex("/error.*")))
				.build().apiInfo(metadata())
				.pathMapping("/").globalOperationParameters(Arrays.asList(headerParam,autherizationParam));
	}

	private ApiInfo metadata() {
		final ApiInfo apiInfo = new ApiInfo("BPMLinks POC on Oracle Cloud", "BPMLinks POC on Oracle Cloud", "1.0", "",
				new springfox.documentation.service.Contact("BPMLinks", "https://bpmlinks.com/", "info@bpmlinks.com"),
				"BPMLinks", "", new ArrayList<VendorExtension>());
		return apiInfo;
	}

}
