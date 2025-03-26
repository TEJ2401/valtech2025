package com.valtech.training.loanclient.config;

import javax.xml.namespace.QName;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.valtech.training.loanserverservice.webservices.LoanServiceWS;

@Configuration
public class WebServiceClientConfig {

	@Bean
	public LoanServiceWS createLoanService() {
		JaxWsProxyFactoryBean proxy=new JaxWsProxyFactoryBean();
		proxy.setServiceClass(LoanServiceWS.class);
		proxy.setServiceName(new QName("http://webservices.loanserverservice.loan.training.valtech.com/", "LoanServiceWSImplService"));
		proxy.setAddress("http://localhost:8080/services/LoanService");
		return proxy.create(LoanServiceWS.class);
		
	}
}
