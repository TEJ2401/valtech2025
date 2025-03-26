package com.valtech.training.question_service.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import com.valtech.training.question_service.VO.QuestionVO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class QuestionControllerTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	
	
	@Test
	public void questionService() {
		
		String url="http://localhost:"+port+"/api/v1/questions/answers/"+26;
		
//		QuestionVO questionvo20=restTemplate.postForObject(url,new QuestionVO(0,"Who is Our BEST PRIME MINISTER TILL DATE?","NARENDRA MODI","MANMOHAN SINGH","AMIT SHAH","YOGI ADITYANATH","NARENDRA MODI","POLITICS"),QuestionVO.class);
//		QuestionVO questionvo21=restTemplate.postForObject(url,new QuestionVO(0,"Who is Our BEST PRIME MINISTER TILL DATE?","NARENDRA MODI","MANMOHAN SINGH","AMIT SHAH","YOGI ADITYANATH","NARENDRA MODI","POLITICS"),QuestionVO.class);
//		QuestionVO questionvo22=restTemplate.postForObject(url,new QuestionVO(0,"Who is Our BEST PRIME MINISTER TILL DATE?","NARENDRA MODI","MANMOHAN SINGH","AMIT SHAH","YOGI ADITYANATH","NARENDRA MODI","POLITICS"),QuestionVO.class);
//		QuestionVO questionvo23=restTemplate.postForObject(url,new QuestionVO(0,"Who is Our BEST PRIME MINISTER TILL DATE?","NARENDRA MODI","MANMOHAN SINGH","AMIT SHAH","YOGI ADITYANATH","NARENDRA MODI","POLITICS"),QuestionVO.class);
//		QuestionVO questionvo24=restTemplate.postForObject(url,new QuestionVO(0,"Who is Our BEST PRIME MINISTER TILL DATE?","NARENDRA MODI","MANMOHAN SINGH","AMIT SHAH","YOGI ADITYANATH","NARENDRA MODI","POLITICS"),QuestionVO.class);
//		QuestionVO questionvo25=restTemplate.postForObject(url,new QuestionVO(0,"Who is Our BEST PRIME MINISTER TILL DATE?","NARENDRA MODI","MANMOHAN SINGH","AMIT SHAH","YOGI ADITYANATH","NARENDRA MODI","POLITICS"),QuestionVO.class);
//		QuestionVO questionvo26=restTemplate.postForObject(url,new QuestionVO(0,"Who is Our BEST PRIME MINISTER TILL DATE?","NARENDRA MODI","MANMOHAN SINGH","AMIT SHAH","YOGI ADITYANATH","NARENDRA MODI","POLITICS"),QuestionVO.class);
		
		
		
		
		String questionIds=restTemplate.getForObject(url,String.class);
		
		System.out.println("Answer "+questionIds);
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
