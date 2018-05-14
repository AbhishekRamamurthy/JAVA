package com.springmvc.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.web.entity.Customer;
import com.springmvc.web.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//inject service
	@Autowired
	private CustomerService customerService;
	
	//@RequestMapping("/list")
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		List<Customer> customers = customerService.getCustomers();
		
		//add customers to model object
		theModel.addAttribute("customers",customers );
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//create model attributed to bind the data
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
	
		//save the customer in object
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		
		//get the customer form database
		
		Customer theCustomer = customerService.getCustomer(theId);
		//set the customer as model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		//send over to form
		return "customer-form";
	}
	
	@PostMapping("/search")
	public String searchCustomer(@RequestParam("theSearchName") String theSearchName, Model theModel) {
		
		List<Customer> theCustomers=customerService.searchCustomer(theSearchName);
		theModel.addAttribute("customers",theCustomers);
		return "list-customers";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int theId, Model theModel) {
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
}
