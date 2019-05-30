package com.netinsight.scheduall.venue.management.config;

import static com.netinsight.scheduall.venue.management.constants.SwaggerConstants.SWAGGER_UI;
import static com.netinsight.scheduall.venue.management.constants.SwaggerConstants.WEB_JARS;
import static com.netinsight.scheduall.venue.management.constants.SwaggerConstants.RESOURCE_LOCATION;
import static com.netinsight.scheduall.venue.management.constants.SwaggerConstants.WEB_JARS_LOCATION;
import static com.netinsight.scheduall.venue.management.constants.SwaggerConstants.AUTHORIZATION;
import static com.netinsight.scheduall.venue.management.constants.SwaggerConstants.TOKEN_MSG;
import static com.netinsight.scheduall.venue.management.constants.SwaggerConstants.TYPE_STR;
import static com.netinsight.scheduall.venue.management.constants.SwaggerConstants.HEADER;
import static com.netinsight.scheduall.venue.management.constants.SwaggerConstants.CONTENT_TYPE;
import static com.netinsight.scheduall.venue.management.constants.SwaggerConstants.API_NAME;
import static com.netinsight.scheduall.venue.management.constants.SwaggerConstants.API_DESCRIPTION;
import static com.netinsight.scheduall.venue.management.constants.SwaggerConstants.VERSION;
import static com.netinsight.scheduall.venue.management.constants.SwaggerConstants.EMPTY_STRING;
import static com.netinsight.scheduall.venue.management.constants.SwaggerConstants.NET_INSIGHT;
import static com.netinsight.scheduall.venue.management.constants.SwaggerConstants.NET_INSIGHT_URL;
import static com.netinsight.scheduall.venue.management.constants.SwaggerConstants.NET_INSIGHT_EMAIL;
import static com.netinsight.scheduall.venue.management.constants.SwaggerConstants.ERROR_PATH;
import static com.netinsight.scheduall.venue.management.constants.SwaggerConstants.ACTUATOR_PATH;
import static com.netinsight.scheduall.venue.management.constants.SwaggerConstants.BACK_SLASH;
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
		registry.addResourceHandler(SWAGGER_UI).addResourceLocations(RESOURCE_LOCATION);
		registry.addResourceHandler(WEB_JARS).addResourceLocations(WEB_JARS_LOCATION);
	}

	@Bean
	public Docket api() {
		final Parameter autherizationParam = new ParameterBuilder().name(AUTHORIZATION)
				.description(TOKEN_MSG).modelRef(new ModelRef(TYPE_STR)).parameterType(HEADER)
				.required(false).build();
		Parameter headerParam = new ParameterBuilder().name(CONTENT_TYPE).modelRef(new ModelRef(TYPE_STR)).parameterType(HEADER).required(true).defaultValue(MediaType.APPLICATION_JSON_VALUE).build();
        
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).paths(Predicates.not(PathSelectors.regex(ERROR_PATH)))
				.build().apiInfo(metadata())
				.pathMapping(BACK_SLASH).globalOperationParameters(Arrays.asList(headerParam,autherizationParam));
	}

	private ApiInfo metadata() {
		final ApiInfo apiInfo = new ApiInfo(API_DESCRIPTION, API_NAME, VERSION, EMPTY_STRING,
				new springfox.documentation.service.Contact(NET_INSIGHT, NET_INSIGHT_URL, NET_INSIGHT_EMAIL),
				NET_INSIGHT, EMPTY_STRING, new ArrayList<VendorExtension>());
		return apiInfo;
	}

}
