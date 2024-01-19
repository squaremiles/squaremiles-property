package com.db.squaremile.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.db.squaremile.service.SleepService;

@RestController
public class HelloController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
	
	@Autowired
	private  RestTemplate restTemplate;
	
	@Autowired
	private  SleepService sleepService;

	

	@GetMapping("/hello")
	public String hello() {
		LOGGER.info("---------Hello method started---------");
		LOGGER.error("---------Hello method started, id missing!---------");
		ResponseEntity<String> responseEntity = this.restTemplate.postForEntity("https://httpbin.org/post", "Hello, Cloud!", String.class);
		return responseEntity.getBody();
	}

	@GetMapping("/exception")
	public String exception() {
		throw new IllegalArgumentException("This id is invalid");
	}

	@GetMapping("/sleep")
	public Long sleep(@RequestParam Long ms) {
		Long result = this.sleepService.doSleep(ms);
		return result;
	}

	/*
	 * @ExceptionHandler(value = { IllegalArgumentException.class }) protected
	 * ResponseEntity<String> handleConflict(IllegalArgumentException ex) {
	 * LOGGER.error(ex.getMessage(), ex); return
	 * ResponseEntity.badRequest().body(ex.getMessage()); }
	 */
}
