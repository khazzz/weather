package com.weather.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.weather.controller.AppErrorController;

/**
 * Tell spring that we have a custom error handling view
 * 
 * @author khazanov
 *
 */
@Configuration
public class CustomErrorConfig {

	@Autowired
	private ErrorAttributes errorAttributes;

	@Bean
	public AppErrorController appErrorController() {
		return new AppErrorController(errorAttributes);
	}

}
