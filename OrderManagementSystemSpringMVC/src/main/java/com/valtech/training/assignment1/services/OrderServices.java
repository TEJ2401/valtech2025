package com.valtech.training.assignment1.services;

import java.util.List;

import com.valtech.training.assignment1.VO.OrderDisplayVO;
import com.valtech.training.assignment1.VO.OrderVO;
import com.valtech.training.assignment1.entities.Orders.OrderStatus;

public interface OrderServices {

	OrderVO createOrder(OrderVO orderVO);

	List<OrderVO> getOrdersByCustomerId(long id);

	List<OrderVO> getAllOrders();

	OrderStatus getOrderStatus(long id);

	List<OrderDisplayVO> getOrderById(long id);

	void updateOrderStatus(long id, OrderStatus orderStatus);


}