package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepo;

@Service
public class CarService {
	
	@Autowired
	CarRepo cr;
	
	public Car saveinfo(Car c) {
		return cr.save(c);		
	}
	
	public List<Car> getOwnerDetails(int o){
		return cr.getOwnerInfo(o);
	}
	
	public List<Car> getAddress(String a){
		return cr.getAddressInfo(a);
	}
	
	public List<Car> getCarName(String n){
		return cr.getCarNameInfo(n);
	}
	
	public List<Car> getCarInformation(int o,String ct){
		return cr.getCarInfo(o, ct);
	}
	
}
