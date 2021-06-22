package com.everis.customerms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.everis.customerms.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Long>{

	@Query(value = "SELECT * FROM customers c WHERE c.numberID = :numberID", nativeQuery = true)
	public Customer findByNumberID(@Param("numberID") String numberID);
	@Query(value = "SELECT * FROM customers c INNER JOIN regions r ON (c.region_id = r.id)  "
			+ "WHERE r.id = :id", nativeQuery = true)
	public List<Customer> findByRegion(@Param("id") Long id);
	
	public List<Customer> findAll();
	//public <S extends Customer> S save(S entity);
	
	@Query(value = "SELECT * FROM customers c WHERE c.id = :id", nativeQuery = true)
	public Optional<Customer> findById(@Param("id") Long id);
	
	//public Customer getById(Long id);
	
	
}
