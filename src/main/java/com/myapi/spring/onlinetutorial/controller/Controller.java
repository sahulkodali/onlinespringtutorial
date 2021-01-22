package com.myapi.spring.onlinetutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapi.spring.onlinetutorial.model.Welcome;

@RestController 
public class Controller {

	@GetMapping(path = "/welcome")
	public Welcome greet() {
		return new Welcome("hello");
	}
}
