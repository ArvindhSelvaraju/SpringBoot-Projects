package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Car;


public interface CarRepo extends JpaRepository<Car, Integer>{
	
	@Query(value="select * from cartable where owners=:o",nativeQuery=true)
	public List<Car> getOwnerInfo(@Param("o") int owners);
	
	@Query(value="select * from cartable where address=:a",nativeQuery=true)
	public List<Car> getAddressInfo(@Param("a") String address);
	
	@Query(value="select * from cartable where car_name=:n",nativeQuery=true)
	public List<Car> getCarNameInfo(@Param("n") String carName);
	
	@Query(value="select * from cartable where owners=:o and car_type=:ct",nativeQuery=true)
	public List<Car> getCarInfo(@Param("o") int owners,@Param("ct") String carType);
	
}
