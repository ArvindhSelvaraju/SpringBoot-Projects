package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserEntity;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService user;
	
	@PostMapping("adduser")
	public UserEntity add(@RequestBody UserEntity us) {
		return user.saveinfo(us);
	}
	
	@PostMapping("addnuser")
	public List<UserEntity>userndetails(@RequestBody List<UserEntity> us){
		return user.savedetails(us);
	}
	
	@GetMapping("showdetails")
	public List<UserEntity> show(){
		return user.showinfo();
	}
	
	@GetMapping("/{userId}")
	public UserEntity getEntityById(@PathVariable int userId) {
		return user.getById(userId);
	}
	
	@PutMapping("updatebyid/{id}")
	public String modifybyid(@PathVariable int id,@RequestBody UserEntity s) {
		return user.updateinfobyid(id,s);
	}
	
	@DeleteMapping("deletedetail")
	public String del(@RequestBody UserEntity ss) {
		user.deleteinfo(ss);	
		return "Deleted successfully";
	}
	
	@DeleteMapping("delid/{id}")
	public String deletemyid(@PathVariable int id) {
		user.deleteid(id);
		return "Deleted successfully";
	}
}
