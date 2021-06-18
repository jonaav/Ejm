package com.everis.customerms.repository;

import java.util.List;
import java.util.Optional;

import com.everis.customerms.entity.Customer;
import com.everis.customerms.entity.Region;

public interface ICustomerRepository {

	
	public Customer findByNumberID(String numberID);
	public List<Customer> findByRegion(Region region);
	public List<Customer> findAll();
	public <S extends Customer> S save(S entity);
	public Optional<Customer> findById(Long id);
	
	
	
}
