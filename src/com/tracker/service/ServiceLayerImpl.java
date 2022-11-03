package com.tracker.service;

import java.lang.annotation.Annotation;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.tracker.DAO.CustomerDAO;
import com.tracker.entity.Customer;


@org.springframework.stereotype.Service
public class ServiceLayerImpl implements Service{

	
	@Autowired
	CustomerDAO customerDAO;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}


	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
		
	}


	@Override
	@Transactional
	public Customer getCustomer(int Id) {
		return customerDAO.getCustomer(Id);
	}


	@Override
	@Transactional
	public void deleteCustomer(int id) {
		
		 customerDAO.deleteCustomer(id);
		
	}

}
