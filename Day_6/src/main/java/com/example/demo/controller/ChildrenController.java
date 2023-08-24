package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ChildrenEntity;
import com.example.demo.service.ChildrenService;

@RestController
public class ChildrenController {
	
	@Autowired
	ChildrenService cser;
	
	@PostMapping("addchild")
	public ChildrenEntity add(@RequestBody ChildrenEntity cs) {
		return cser.saveinfo(cs);
	}
	
	@GetMapping("/{name}")
	public List<ChildrenEntity> getsortinfo(@PathVariable String name){
		return cser.sortinfo(name);
	}
	
	@GetMapping("/{pageno}/{pagesize}")
	public List<ChildrenEntity> showpageinfo(@PathVariable int pageno,@PathVariable int pagesize){
		return cser.getByPage(pageno, pagesize);
	}
	
	@GetMapping("/{pageno}/{pagesize}/{name}")
	public List<ChildrenEntity> sortpageinfo(@PathVariable int pageno,@PathVariable int pagesize,@PathVariable String name){
		return cser.sortPageInfo(pageno, pagesize, name);
	}
}
