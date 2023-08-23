package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepo;

@Service
public class BookService {
	
	@Autowired
	BookRepo br;
	
	public Book saveinfo(Book b) {
		return br.save(b);
	}
	
	public List<Book> showinfo(){
		return br.findAll();
	}
	
	public Book getById(int id) {
		return br.findById(id).orElse(null);
	}
	
	public String updateinfobyid(int id,Book b) {
		br.saveAndFlush(b);
		if(br.existsById(id)) {
			return "Updated";
		}
		else {
			return "Enter Valid Id";
		}
	}
	
	public String deletebyid(int id) {
		br.deleteById(id);
		return "Deleted successfully";
	}
}
