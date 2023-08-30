package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer>{
	
	@Query(value = "select * from usertable where project_name=:pn",nativeQuery = true)
	public List<UserEntity> getbyprojectname(@Param("pn") String name);
}
