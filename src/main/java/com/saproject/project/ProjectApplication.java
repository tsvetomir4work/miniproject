package com.saproject.project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectApplication implements ApplicationRunner {

	private static final Logger logger = LogManager.getLogger(ProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}
	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		logger.debug("Debugging log");
		logger.info("Info log");
		logger.warn("Hey, This is a warning!");
		logger.error("Oops! We have an Error. OK");
		logger.fatal("Damn! Fatal error. Please fix me.");
	}

}
