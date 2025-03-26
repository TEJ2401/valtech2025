package com.valtech.training.assignment1.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.assignment1.VO.AddItemVO;
import com.valtech.training.assignment1.VO.CustomerVO;
import com.valtech.training.assignment1.VO.ItemVO;
import com.valtech.training.assignment1.VO.LineItemVO;
import com.valtech.training.assignment1.VO.OrderDisplayVO;
import com.valtech.training.assignment1.VO.OrderVO;
import com.valtech.training.assignment1.entities.Customer;
import com.valtech.training.assignment1.entities.Item;
import com.valtech.training.assignment1.entities.LineItem;
import com.valtech.training.assignment1.entities.Orders;
import com.valtech.training.assignment1.entities.Orders.OrderStatus;
import com.valtech.training.assignment1.repo.ItemRepo;
import com.valtech.training.assignment1.repo.OrderRepo;



@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrderServicesImpl implements OrderServices {

	
	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private ItemRepo itemRepo;

	@Autowired
	private InventoryServices inventoryServices;

	@Autowired
	private CustomerServices customerServices;
	
	
	@Override
	public OrderVO createOrder(OrderVO orderVO) {
		int flag=0;
		Orders a=orderVO.to();	
		
		for(LineItemVO lineItemVO:orderVO.getLineItems()) {
			Item item=inventoryServices.getItemById(lineItemVO.itemId()).to();
			if(item.checkItemAvailability(lineItemVO.itemQuantity())) {
				if(item.checkReOrderStatus(lineItemVO.itemQuantity())) {
					inventoryServices.refillInventory(lineItemVO.itemId());
				}
				else {
					item.setCurrentQuantity(item.getCurrentQuantity()-lineItemVO.itemQuantity());
					inventoryServices.createOrUpdateInventory(ItemVO.from(item));
				}
			}
			else {
				
				flag=1;
			}
		}
		
		if(flag!=1) {
			Set<LineItem>lineItems=orderVO.getLineItems().stream().map(w->new LineItem(inventoryServices.getItemById(w.itemId()).to(),a,w.itemQuantity())).collect(Collectors.toSet());
			a.setLineItems(lineItems);
			Customer customer=customerServices.getCustomerById(orderVO.getCustomerId()).to();
			System.out.println("Inside Customer Class"+customer.getName());
			a.setOrderStatus(OrderStatus.PROCESSING);
			a.setCustomer(customer);
			OrderVO order=OrderVO.from(orderRepo.save(a));
			return order;
		}

		
		return null;	
	
	}

	
	@Override
	public List<OrderVO> getOrdersByCustomerId(long id){
		List<OrderVO> orderVO= orderRepo.getOrdersByCustomerId(id).stream().map(w->OrderVO.from(w)).collect(Collectors.toList());
		return orderVO;
		
	}
	
	@Override
	public List<OrderVO> getAllOrders(){
		List<OrderVO> orderVO=orderRepo.findAll().stream().map(w->OrderVO.from(w)).collect(Collectors.toList());
		return orderVO;
	}
	
	
	@Override
	public List<OrderDisplayVO> getOrderById(long id) {
		Orders order=orderRepo.getReferenceById(id);
		List<OrderDisplayVO> orderDisplay=order.getLineItems().stream().map(w->new OrderDisplayVO(w.getItem().getId(),w.getItem().getName(),w.getOrderQuantity())).collect(Collectors.toList());
		return orderDisplay;
		
	}
	
	
	
	@Override
	public OrderStatus getOrderStatus(long id) {
		
		return orderRepo.getReferenceById(id).getOrderStatus();
		
	}
	
	@Override
	public void updateOrderStatus(long id,OrderStatus orderStatus) {
		
		Orders order=orderRepo.getReferenceById(id);
		order.setOrderStatus(orderStatus);
		orderRepo.save(order);
	}
	
}
