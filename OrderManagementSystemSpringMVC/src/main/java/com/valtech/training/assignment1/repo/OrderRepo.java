package com.valtech.training.assignment1.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.assignment1.entities.Orders;


@Repository
public interface OrderRepo extends JpaRepository<Orders, Long> {

	public List<Orders> getOrdersByCustomerId(long id);
	
	
}
