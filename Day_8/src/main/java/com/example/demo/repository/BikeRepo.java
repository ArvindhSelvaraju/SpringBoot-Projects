package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BikeEntity;

@Repository
public interface BikeRepo extends JpaRepository<BikeEntity, Integer> {
	
	@Query(value = "select * from biketable where year =:yr",nativeQuery = true)
	public List<BikeEntity> getByYear(@Param("yr") int yr);
	@Query(value = "select * from biketable where year = :yr and bike_name =:bn",nativeQuery = true)
	public List<BikeEntity> getByYearAndName(@Param("yr")int yr,@Param("bn") String bn);
	@Query(value = "select * from biketable where bike_name =:bn",nativeQuery = true)
	public List<BikeEntity> getByName(@Param("bn")String bn);
}
