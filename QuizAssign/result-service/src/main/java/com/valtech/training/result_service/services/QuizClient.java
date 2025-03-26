package com.valtech.training.result_service.services;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.valtech.training.result_service.VO.QuizResultVO;
import com.valtech.training.result_service.VO.QuizVO;

@Component
public class QuizClient {

	
	
	public QuizResultVO getQuizById(long id) {
		
		RestTemplate restTemplate=new RestTemplate();

		String url="http://localhost:9020/api/v1/quizes/"+id;
		
		QuizResultVO quizResult= restTemplate.getForObject(url,QuizResultVO.class);
		
		return quizResult;
	}
	
	public List<QuizResultVO> getAllQuizes(){
		RestTemplate restTemplate=new RestTemplate();
		
		String url="http://localhost:9020/api/v1/quizes/";
		
		List<QuizResultVO> allQuizes=restTemplate.getForObject(url,List.class);
	
		return allQuizes;		
	}
	
	
}
