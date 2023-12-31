package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BikeEntity;
import com.example.demo.service.BikeService;

@RestController
public class BikeController {
	
	@Autowired
	BikeService bser;
	
	@PostMapping("add")
	public BikeEntity save(@RequestBody BikeEntity s) {
		return bser.add(s);
	}
	@GetMapping("/year/{year}")
	public List<BikeEntity> showByYear(@PathVariable int year) {
		return bser.getByYear(year);
	}
	@GetMapping("/year/name/{year}/{name}")
	public List<BikeEntity> getYearandName(@PathVariable int year,@PathVariable String name){
		return bser.getByYearAndName(year, name);
	}
	@GetMapping("/name/{name}")
	public List<BikeEntity> getbyname(@PathVariable String name){
		return bser.getByName(name);
	}
}
