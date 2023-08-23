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

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@RestController
public class Controller {
	
	@Autowired
	BookService bser;
	
	@PostMapping("addbook")
	public Book add(@RequestBody Book b) {
		return bser.saveinfo(b);
	}
	
	@GetMapping("showdetails")
	public List<Book> show(){
		return bser.showinfo();
	}
	
	@GetMapping("/{id}")
	public Book getEntityById(int id) {
		return bser.getById(id);
	}
	
	@PutMapping("updatebyid/{id}")
	public String updatebyid(@PathVariable int id,@RequestBody Book b) {
		return bser.updateinfobyid(id, b);
	}
	
	@DeleteMapping("deletebyid/{id}")
	public String deletebyid(int id) {
		return bser.deletebyid(id);
	}
}
