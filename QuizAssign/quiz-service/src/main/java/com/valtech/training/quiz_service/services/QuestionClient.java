package com.valtech.training.quiz_service.services;

import java.lang.reflect.Array;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.Arrays;
import java.util.List;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.valtech.training.quiz_service.VO.QuestionVO;
import com.valtech.training.quiz_service.VO.QuizQuestionVO;

@Component
public class QuestionClient {
	
	
	
	
	public QuizQuestionVO getQuestion(long id) {
		
		RestTemplate httpClient=new RestTemplate();
		
		
		String url="http://localhost:9010/api/v1/questions/"+id;
		
		QuestionVO question= httpClient.getForObject(url,QuestionVO.class);
	
		
		return new QuizQuestionVO(question.id(),question.question(),question.option1(),question.option2(),question.option3(),question.option4());

	}
	
	
	public QuizQuestionVO getQuestionById(long id) {
		
		RestTemplate httpClient=new RestTemplate();
		
		String url="http://localhost:9010/api/v1/questions/"+id;
		QuestionVO question=httpClient.postForObject(url,"", QuestionVO.class);
		QuizQuestionVO quizResult=new QuizQuestionVO(question.id(),question.question(),question.option1(),question.option2(),question.option3(),question.option4());
		
		return quizResult;	
	}
	
	public List<Integer> getQuestionsByTopic(String topic){
		RestTemplate httpClient=new RestTemplate();
		
		String url="http://localhost:9010/api/v1/questions/"+topic;

		
		List<Integer> getQuestionsById=httpClient.getForObject(url,List.class);
		System.out.println(getQuestionsById);
		System.out.println("IN questionVO");

		return getQuestionsById;
		
	}
	
	public String getAnswerById(long id) {
		
		RestTemplate httpClient=new RestTemplate();
		
		String url="http://localhost:9010/api/v1/questions/answers/"+id;
		String answer=httpClient.getForObject(url,String.class);
		return answer;
		
	}
	
	
	public List<QuestionVO> getAllQuestions(){
		
		RestTemplate httpClient=new RestTemplate();
		String url="http://localhost:9010/api/v1/questions";
		List questions= httpClient.getForObject(url,List.class);
		return questions;
	
	}
	
}
