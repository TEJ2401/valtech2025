package com.valtech.training.assignment1.controllers;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.valtech.training.assignment1.VO.AddItemVO;
import com.valtech.training.assignment1.VO.ItemVO;
import com.valtech.training.assignment1.VO.LineItemVO;
import com.valtech.training.assignment1.VO.OrderVO;
import com.valtech.training.assignment1.entities.Orders.OrderStatus;
import com.valtech.training.assignment1.services.OrderServices;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/api/v1/orders")
@SessionAttributes(names = {"itemsl","orders","customerId"})
public class OrdersController {
	
	
	@Autowired
	private OrderServices orderServices;
	
	
	@GetMapping("/")

	public String getOrders(Model model) {
		
		Set<LineItemVO> lineItemVO=(Set<LineItemVO>)model.getAttribute("itemsl");
		System.out.println("lineItemVO"+lineItemVO);
		model.addAttribute("orders",orderServices.getAllOrders());
		if(lineItemVO!=null) {
			System.out.println("InSide If");
	
			lineItemVO.clear();
			model.addAttribute("itemsl",lineItemVO);
		}

		return "Order";
	}
	
	@ModelAttribute("lineItems")
	public LineItemVO populateModel(Model model,@RequestParam(required = false) String itemId,@RequestParam(required = false) String itemQuantity,@RequestParam(required=false) String submitButton) {
		
		if(itemId=="" && itemQuantity=="") {
			return new LineItemVO(0,0);
		}
		
		if(itemId!=null && !itemId.isEmpty() && itemQuantity!=null && !itemQuantity.isEmpty()) {
			return new LineItemVO(Integer.parseInt(itemId) ,Integer.parseInt(itemQuantity));
		}
		return null;
	}
	
	
	@PostMapping("/place")
	public String createOrders(@ModelAttribute("lineItems") LineItemVO itemVO,Model model,@RequestParam(required=false)String submitButton,@RequestParam(required=false) Integer customerId) {
		
		model.addAttribute("customerId",customerId!=null?customerId:Integer.parseInt(model.getAttribute("customerId").toString()));

		if("placeOrder".equals(submitButton)) {
			Set<LineItemVO>itemlists=(Set<LineItemVO>)model.getAttribute("itemsl");
			System.out.println(itemlists);
			System.out.println("Errors");
			System.out.println(model.getAttribute("customerId"));
			String cus=model.getAttribute("customerId").toString();
			int cusId=Integer.parseInt(cus);
			System.out.println("Customer Id-----"+cusId);
			OrderVO orderVO=new OrderVO(0,OrderStatus.PENDING,itemlists,cusId);
			orderServices.createOrder(orderVO);
			System.out.println("In Here");
			
		}
		
		else if(model.getAttribute("itemsl")==null) {
			Set<LineItemVO> itemlists=new HashSet<>();
			itemlists.add(itemVO);
			model.addAttribute("itemsl", itemlists);
			System.out.println("Item"+model.getAttribute("itemsl"));
		}
		else {
			System.out.println("List not Empty");
			System.out.println(model.getAttribute("itemsl"));
			@SuppressWarnings("unchecked")
			Set<LineItemVO> listsofItemVO=(Set<LineItemVO>)model.getAttribute("itemsl");
			listsofItemVO.add(itemVO);
			model.addAttribute("itemsl",listsofItemVO);
		}
		
		System.out.println(model.getAttribute("itemsl"));
		return "Order";
	}
	
	
	
	@GetMapping("/{id}")
	public String getOrderById(Model model,@PathVariable long id,@RequestParam(required = false) String Update,@RequestParam(required=false) String View) {
		System.out.println(View);
		System.out.println(Update);
		model.addAttribute("orderId",id);
		model.addAttribute("orders",orderServices.getOrderById(id));
		model.addAttribute("OrderStatus",orderServices.getOrderStatus(id));
		if(Update!=null) {
			System.out.println(Update);
			model.addAttribute("prop","Update");
		}
		
		
		else 
		{
			System.out.println(View);
			model.addAttribute("prop","View");
		}
		return "orders";
		
		
		
	}
	
	@PostMapping("/{id}")
	public String updateOrder(@PathVariable long id,@RequestParam String orderStatus) {
		
		orderServices.updateOrderStatus(id,OrderStatus.valueOf(orderStatus));
		
		
		return "redirect:/api/v1/orders/";
	
		
		
	}

	
	
}
