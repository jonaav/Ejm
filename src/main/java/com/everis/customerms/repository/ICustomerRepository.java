package com.everis.customerms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.everis.customerms.entity.Customer;
@RepositoryRestResource(collectionResourceRel = "Customer",path="customers")
public interface ICustomerRepository extends JpaRepository<Customer, Long>{

	
	public Customer findByNumberId(@Param("numberId") String numberId);
	
	public List<Customer> findByRegion(@Param("id") Long id);
	
	//public List<Customer> findAll();
	//public <S extends Customer> S save(S entity);
	
	//public Optional<Customer> findById(Long id);
	
	
}
