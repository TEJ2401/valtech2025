package com.valtech.training.api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

	
	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder.routes().route(p->p.path("/get").uri("http://httpbin.org:80")).route(p->p.path("/api/v1/questions/**").uri("lb://QUESTION-SERVICE")).route(p->p.path("/api/v1/results/**").uri("lb://RESULT-SERVICE")).route(p->p.path("/api/v1/quizMaster/**").uri("lb://QUIZ-SERVICE")).route(p->p.path("/api/v1/quizes/**").uri("lb://QUIZ-SERVICE")).build();
	}
	
	
	
}
