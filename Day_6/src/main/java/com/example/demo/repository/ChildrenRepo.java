package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ChildrenEntity;

public interface ChildrenRepo extends JpaRepository<ChildrenEntity, Integer> {

}
