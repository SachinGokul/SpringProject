package com.tracker.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tracker.DAO.CustomerDAO;
import com.tracker.entity.Customer;
import com.tracker.service.Service;
import com.tracker.service.ServiceLayerImpl;



@Controller
@RequestMapping("/customer")
public class CustomerController {

 
	@Autowired
	Service service;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers from the dao
		List<Customer> theCustomers = service.getCustomers();
				
		System.out.println("List of customer -->"+theCustomers);
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model)
	{
		Customer customer = new Customer();
		model.addAttribute("customer",customer);
		return "customer-form";
	}
	
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer)
	{
		
		service.saveCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model)
	{
		//get the customer from database
		Customer customer = service.getCustomer(id);
		
		//set the customer as a model attribute to pre-populate the form
		model.addAttribute("customer",customer);
		
		
		//send over the form
		return "customer-form";
		
	}
	
	@GetMapping("delete")
	public String deleteCustomer(@RequestParam("customerId") int Id)
	{
		
		
		service.deleteCustomer(Id);
		return "redirect:/customer/list";
		
	}
}


