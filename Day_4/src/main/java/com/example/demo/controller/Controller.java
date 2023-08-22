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

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class Controller {
	
	@Autowired
	StudentService sser;
	
	@PostMapping("addstudent")
	public Student add(@RequestBody Student s) {
		return sser.saveinfo(s);
	}
	
	@GetMapping("showdetails")
	public List<Student> show(){
		return sser.showinfo();
	}
	
	@GetMapping("/{id}")
	public Student getEntityById(@PathVariable int id) {
		return sser.getById(id);
	}
	
	@PutMapping("update")
	public Student modify(@RequestBody Student s) {
		return sser.changeinfo(s);
	}
	
	@PutMapping("updatebyid/{id}")
	public String modifybyid(@PathVariable int id,@RequestBody Student s) {
		return sser.updateinfobyid(id,s);
	}
	
	@DeleteMapping("delid/{id}")
	public String deletemyid(@PathVariable int id) {
		sser.deleteid(id);
		return "Deleted Successfully";
	}
}
