package com.everis.customerms.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.everis.customerms.entity.Customer;
import com.everis.customerms.entity.Region;
import com.everis.customerms.service.ICustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	ICustomerService customerService;

	@GetMapping
	public ResponseEntity<List<Customer>> listAllCustomers(
			@RequestParam(name = "regionId", required = false) Long regionId) {
		List<Customer> customers = new ArrayList<>();
		if (regionId == null) {
			customers = customerService.findCustomerAll();
			if (customers.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		} else {
			Region region = new Region();
			region.setId(regionId);
			customers = customerService.findCustomersByRegion(region);
			if (customers == null) {
				log.error("Customers with region id {} not found.", regionId);
				return ResponseEntity.notFound().build();
			}

		}
		return ResponseEntity.ok(customers);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id) {
		log.info("Fetchin Customer with id {}", id);
		Customer customer = customerService.getCustomer(id);
		if (null == customer) {
			log.error("customer with id {} not found.", id);
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(customer);
	}

	@PostMapping
	public ResponseEntity<Customer> createCustomer(/*@Valid*/ @RequestBody Customer customer, BindingResult result) {
		log.info("Creating Customer : {}", customer);
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
		}
		Customer customerDB = customerService.createCustomer(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(customerDB);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> UpdateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
		log.info("Updating Customer with id {}", id);

		Customer currentCustomer = customerService.getCustomer(id);

		if (currentCustomer == null) {
			log.error("Unable to update. Customer with id {} not found.", id);
			return ResponseEntity.notFound().build();
		}
		customer.setId(id);
		currentCustomer = customerService.updateCustomer(customer);
		return ResponseEntity.ok(currentCustomer);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") long id) {
		log.info("Fetching & DeletingCustomer with id {}", id);
		Customer customer = customerService.getCustomer(id);
		if (customer == null) {
			log.error("Unable to delete. Customer with id {} not found.", id);
			return ResponseEntity.notFound().build();
		}
		customer = customerService.deleteCustomer(customer);
		return ResponseEntity.ok(customer);
	}

	private String formatMessage(BindingResult result) {
		List<Map<String, String>> errors = result.getFieldErrors().stream().map(err -> {
			Map<String, String> error = new HashMap<>();
			error.put(err.getField(), err.getDefaultMessage());
			return error;
		}).collect(Collectors.toList());
		ErrorMessage errorMessage = ErrorMessage.builder().code("01").messages(errors).build();

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "";
		try {
			jsonString = mapper.writeValueAsString(errorMessage);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonString;

	}

}
