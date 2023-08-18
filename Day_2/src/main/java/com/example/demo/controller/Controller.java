package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@Value("${var}")
	public String name;
	
	@GetMapping("disp")
	public String display() {
		return "Welcome "+name;
	}
}
