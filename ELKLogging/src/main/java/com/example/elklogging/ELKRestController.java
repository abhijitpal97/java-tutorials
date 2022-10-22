package com.example.elklogging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("elkstack")
public class ELKRestController {
	Logger log = LoggerFactory.getLogger(ELKRestController.class);
	
	@GetMapping("/test")
	public String getTest()
	{
		log.info("Logging for Controller - Test");
		return "Test Success";
	}

}
