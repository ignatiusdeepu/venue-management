package com.netinsight.scheduall.venue.management;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class VenueManagementApplication {

	private static final Logger logger = LoggerFactory.getLogger(VenueManagementApplication.class);
	
	private static final String NI_ENV="NI_ENV";
	
	public static void main(String[] args) {
		logger.debug("Begin VenueManagementApplication::main");
		String environment = System.getenv(NI_ENV);
		new SpringApplicationBuilder().sources(VenueManagementApplication.class).profiles(environment).build().run(args);
		logger.debug("End VenueManagementApplication::main");
	}

}
