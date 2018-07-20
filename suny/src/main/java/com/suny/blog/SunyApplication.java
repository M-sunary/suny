package com.suny.blog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SunyApplication {
	private static final Logger logger = LoggerFactory.getLogger(SunyApplication.class);

	public static void main(String[] args) {
	    logger.info("进入main 方法");
		SpringApplication.run(SunyApplication.class, args);
	}
}
