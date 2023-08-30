package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.demo.model.UserEntity;
import com.example.demo.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo ur;
	
	public UserEntity saveinfo(UserEntity us) {
		return ur.save(us);
	}
	
	public List<UserEntity> savedetails(List<UserEntity> us){
		return (List<UserEntity>)ur.saveAll(us);
	}
	
	public List<UserEntity> showinfo(){
		return ur.findAll();
	}
	
	public UserEntity getById(int userId) {
		return ur.findById(userId).orElse(null);
	}
	
	public String updateinfobyid(int userId,UserEntity us) {
		ur.saveAndFlush(us);
		if(ur.existsById(userId)) {
			return "Updated	";
		}
		else {
			return "Enter Valid Id";
		}
	}
	
	public void deleteinfo(UserEntity ss) {
		ur.delete(ss);
	}
	
	public void deleteid(int userId) {
		ur.deleteById(userId);
	}
	
	public List<UserEntity> sortinfo(String s){
		return ur.findAll(Sort.by(Sort.Direction.ASC,s));
	}
	
	public List<UserEntity> getByPage(int pgno,int pgsize){
		Page<UserEntity> p=ur.findAll(PageRequest.of(pgno, pgsize));
		return p.getContent();
	}
	
	public List<UserEntity> sortPageInfo(int pgno,int pgsize,String s){
		PageRequest pageable=PageRequest.of(pgno, pgsize,Sort.by(Sort.Direction.ASC,s));
		Page<UserEntity> p=ur.findAll(pageable);
		return p.getContent();
	}
	
	public List<UserEntity> getbypname(String pn){
		return ur.getbyprojectname(pn);
	}
}
