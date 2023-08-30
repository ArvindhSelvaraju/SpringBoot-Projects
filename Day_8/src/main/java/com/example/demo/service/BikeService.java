package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.BikeEntity;
import com.example.demo.repository.BikeRepo;

@Service
public class BikeService {
	
	@Autowired
	BikeRepo br;
	
	public BikeEntity add(BikeEntity s) {
		return br.save(s);
	}
	public List<BikeEntity> getByYear(int year){
		return br.getByYear(year);
	}
	public List<BikeEntity> getByYearAndName(int year,String name){
		return br.getByYearAndName(year, name);
	}
	public List<BikeEntity> getByName(String name){
		return br.getByName(name);
	}
}
