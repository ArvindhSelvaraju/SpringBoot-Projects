package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.ChildrenEntity;
import com.example.demo.repository.ChildrenRepo;

@Service
public class ChildrenService {
	
	@Autowired
	ChildrenRepo cr;
	
	public ChildrenEntity saveinfo(ChildrenEntity cs) {
		return cr.save(cs);
	}
	
	public List<ChildrenEntity> sortinfo(String s){
		return cr.findAll(Sort.by(Sort.Direction.ASC,s));
	}
	
	public List<ChildrenEntity> getByPage(int pgno,int pgsize){
		Page<ChildrenEntity> p=cr.findAll(PageRequest.of(pgno, pgsize));
		return p.getContent();
	}
	
	public List<ChildrenEntity> sortPageInfo(int pgno,int pgsize,String s){
		PageRequest pageable=PageRequest.of(pgno, pgsize,Sort.by(Sort.Direction.ASC,s));
		Page<ChildrenEntity> p=cr.findAll(pageable);
		return p.getContent();
	}
}
