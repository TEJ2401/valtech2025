package com.valtech.training.quiz_service.services;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ResultClient {

	
	
	public int getResultById(long id) {
		
		RestTemplate httpClient=new RestTemplate();
		
		String url="http://localhost:9030/api/v1/results/"+id;
		
		int score=httpClient.postForObject(url,new Object(),Integer.class);
		
		return score;
		
	}
	
}


