package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Car;
import com.example.demo.service.CarService;

@RestController
public class CarController {
	
	@Autowired
	CarService cser;
	
	@PostMapping("addcar")
	public Car add(@RequestBody Car c) {
		return cser.saveinfo(c);
	}
	
	@GetMapping("/owners/{owners}")
	public List<Car> getownerinfo(@PathVariable int owners){
		return cser.getOwnerDetails(owners);
	}
	
	@GetMapping("/address/{address}")
	public List<Car> getaddrinfo(@PathVariable String address){
		return cser.getAddress(address);
	}
	
	@GetMapping("/carName/{carName}")
	public List<Car> getcarnameinfo(@PathVariable String carName){
		return cser.getCarName(carName);
	}
	
	@GetMapping("/owners/{owners}/carType/{carType}")
	public List<Car> getcarinfo(@PathVariable int owners,@PathVariable String carType){
		return cser.getCarInformation(owners, carType);
	}
}
