package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty;

@RestController
public class Controller {
	@GetMapping("greet")
	public String Welcome() {
		return "Welcome String Boot!";
	}
	
	public String studentName="IamNeo";
	@GetMapping("disp")
	public String getName() {
		return "Welcome "+studentName+"!";
	}
	
	public String yourFavColor="Blue";
	@GetMapping("color")
	public String getMyFav() {
		return "My favorite color is "+yourFavColor;
	}
	
}
