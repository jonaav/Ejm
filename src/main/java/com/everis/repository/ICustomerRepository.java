package com.everis.repository;

import java.util.List;
import java.util.Optional;

import com.everis.entity.Customer;
import com.everis.entity.Region;

public interface ICustomerRepository {

	
	public Customer findByNumberID(String numberID);
	public List<Customer> findByRegion(Region region);
	public List<Customer> findAll();
	public <S extends Customer> S save(S entity);
	public Optional<Customer> findByID(Long id);
	
	
	
}
