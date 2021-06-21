/*package com.everis.customerms.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.everis.customerms.entity.Customer;
import com.everis.customerms.entity.Region;

@Repository
public class CustomerRepositoryImpl implements ICustomerRepository{
		
	private List<Region> regiones = new ArrayList<Region>();
	private List<Customer> customers = new ArrayList<Customer>();

	private void init() {
		Region r1 = new Region(1L, "Sudamérica");
		Region r2 = new Region(2L, "Centroamérica");
		Region r3 = new Region(3L, "Norteamérica");
		Region r4 = new Region(4L, "Europa");
		Region r5 = new Region(5L, "Asia");
		Region r6 = new Region(6L, "Africa");
		Region r7 = new Region(7L, "Oceanía");
		Region r8 = new Region(8L, "Antártida");
	
		
		regiones.add(r1);
		regiones.add(r2);
		regiones.add(r3);
		regiones.add(r4);
		regiones.add(r5);
		regiones.add(r6);
		regiones.add(r7);
		regiones.add(r8);
		
		Customer c1 = new Customer(1L, "32404580", "Andrés", "Gúzman", 
				"profesor@bolsadeideas.com", "", r1, "CREATED");
		
		customers.add(c1);
		
	}
	
	
	public CustomerRepositoryImpl() {
		init();
	}
	

	@Override
	public List<Customer> findAll() {
		return customers;
	}

	@Override
	public Optional<Customer> findById(Long id) {
		return customers.stream().filter(p -> p.getId() == id).findFirst();
	}
	
	@Override
	public <S extends Customer> S save(S entity) {
		customers.add(entity);
		return entity;
	}
	
	@Override
	public List<Customer> findByRegion(Region region) {
		
		return customers.stream().filter(
				p -> p.getRegion().getId() == region.getId()).collect(Collectors.toList());
	}

	@Override
	public Customer findByNumberID(String numberID) {
		
		return customers.stream().filter(
				p -> p.getNumberID().equals(numberID)).findAny().orElse(null);
	}




}
*/