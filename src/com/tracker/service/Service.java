package com.tracker.service;

import java.util.List;

import com.tracker.entity.Customer;

public interface Service {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int Id);

	public void deleteCustomer(int id);

}
