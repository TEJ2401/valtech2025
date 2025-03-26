package com.valtech.training.loanserverservice.config;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.valtech.training.loanserverservice.services.LoanService;
import com.valtech.training.loanserverservice.webservices.LoanServiceWSImpl;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;





@Configuration
public class WebServiceConfig {

	@Autowired
	private Bus bus;
	
	@Bean
	public Endpoint loanServiceWS(LoanService loanService) {
		EndpointImpl endPoint=new EndpointImpl(bus,new LoanServiceWSImpl(loanService));
		endPoint.setAddress("/LoanService");
		endPoint.publish();
		return endPoint;
	
	}
	
}
