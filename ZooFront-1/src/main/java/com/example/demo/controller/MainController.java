package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class MainController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

	@RequestMapping("/")
	public String MainPage() {
		LOGGER.info("Handling / request");
		return "open/MainPage";
	}

	@RequestMapping("/AdminView")
	public String AdminView() {
		LOGGER.info("Handling /AdminView request");
		return "open/AdminView";
	}

	@RequestMapping("/EmployeeLoginView")
	public String EmployeeLoginView() {
		LOGGER.info("Handling /EmployeeLoginView request");
		return "open/EmployeeLoginView";
	}
}
