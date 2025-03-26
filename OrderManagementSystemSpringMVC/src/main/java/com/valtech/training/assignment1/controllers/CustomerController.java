package com.valtech.training.assignment1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valtech.training.assignment1.VO.CustomerVO;
import com.valtech.training.assignment1.VO.OrderVO;
import com.valtech.training.assignment1.entities.Customer;
import com.valtech.training.assignment1.services.CustomerServices;
import com.valtech.training.assignment1.services.OrderServices;

@Controller
@RequestMapping("/api/v1/customers")
public class CustomerController {

	
	@Autowired
	private CustomerServices customerServices;

	@Autowired 
	private OrderServices orderServices;
	
	
	@GetMapping("/")
	public String registerCustomer(Model model) {
		System.out.println(customerServices.getCustomers());
		model.addAttribute("customers", customerServices.getCustomers());
		
		return "Customer";
		
	}
	

	@ModelAttribute("customers")
	public CustomerVO createCustomer(@RequestParam(required = false) String name,@RequestParam(required = false) Integer age,@RequestParam(required=false) String currentCity,@RequestParam(required = false) Integer currentPinCode,@RequestParam(required=false) String currentStreet,@RequestParam(required=false) String permanantCity,@RequestParam(required=false) Integer permanantPinCode,@RequestParam(required=false) String permanantStreet) {
		if(name!=null && age!=0 && currentCity!=null && currentPinCode!=0 && currentStreet!=null && permanantCity!=null && permanantPinCode!=0 && permanantStreet!=null ) {
			return new CustomerVO(0,name,age,currentCity,currentPinCode,currentStreet,permanantCity,permanantPinCode,permanantStreet,null);
		}
		else {
			return new CustomerVO(0,null,0,null,0,null,null,0,null,null);
			
		}
	}
	
	
	@PostMapping("/")
	public String createCustomer(@ModelAttribute("customers") CustomerVO customerVO,Model model) {
		System.out.println(customerVO);
	CustomerVO customer=customerServices.createCustomer(customerVO);
	model.addAttribute("customer",customer);
	return "Order";
		
	}
	
	@GetMapping("/{id}")
	public String getOrderByCustomer(@PathVariable long id,Model model) {
		
		CustomerVO customer=customerServices.getCustomerById(id);
		List<OrderVO>orderVOS=orderServices.getOrdersByCustomerId(id);
		model.addAttribute("customer",customer);
		model.addAttribute("orders",orderVOS);
		return "Customer";
	}
	
	
	
}
