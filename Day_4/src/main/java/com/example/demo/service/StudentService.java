package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	StudentRepo sr;

	public Student saveinfo(Student s) {
		return sr.save(s);
	}
	
	public List<Student> showinfo(){
		return sr.findAll();
	}
	
	public Student getById(int id) {
		return sr.findById(id).orElse(null);
	}
	
	public Student changeinfo(Student s) {
		return sr.saveAndFlush(s);
	}
	
	public String updateinfobyid(int id,Student s) {
		sr.saveAndFlush(s);
		if(sr.existsById(id)) {
			return "Updated	";
		}
		else {
			return "Enter Valid Id";
		}
	}
	
	public void deleteid(int id) {
		sr.deleteById(id);
	}

}
