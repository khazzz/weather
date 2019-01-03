package com.weather.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	final static Logger logger = LogManager.getLogger(IndexController.class);

	@RequestMapping("/")
	public String slash() {
		return "redirect:/weather/";
	}

	@RequestMapping("/index")
	public String index() {
		return slash();
	}

}
