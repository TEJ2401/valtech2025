package com.valtech.training.assignment1.services;

import java.util.List;

import com.valtech.training.assignment1.VO.CustomerVO;

public interface CustomerServices {

	CustomerVO createCustomer(CustomerVO customerVO);

	CustomerVO getCustomerById(long id);

	List<CustomerVO> getCustomers();

}