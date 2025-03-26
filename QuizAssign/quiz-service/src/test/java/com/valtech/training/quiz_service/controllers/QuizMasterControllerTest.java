package com.valtech.training.quiz_service.controllers;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import com.valtech.training.quiz_service.VO.QuizMasterVO;
import com.valtech.training.quiz_service.VO.QuizVO;
import com.valtech.training.quiz_service.VO.ResponseVO;
import com.valtech.training.quiz_service.VO.ResponsesVO;

import static org.springframework.test.web.servlet.RequestBuilder.*;
import static org.springframework.test.web.servlet.ResultMatcher.*;
import static org.springframework.test.web.client.RequestMatcher.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class QuizMasterControllerTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testQuiz() {
		
		
		String url="http://localhost:"+port+"/api/v1/quizes/"+1;
		QuizVO questionQuiz=testRestTemplate.getForObject(url,QuizVO.class);
		System.out.println("In the QuestionQuiz"+questionQuiz);

	}
	
	
//	@Test
//	public void takeQuiz() {
//		String url="http://localhost:"+port+"/api/v1/quizes/"+1;
//		List<ResponseVO> responseVO=List.of(new ResponseVO(21L,"NARENDRA MODI"),new ResponseVO(26L,"NARENDRA MODI"),new ResponseVO(18L,"NARENDRA MODI"),new ResponseVO(24L,"NARENDRA MODI"),new ResponseVO(16L,"NARENDRA MODI"),new ResponseVO(22L,"NARENDRA MODI"),new ResponseVO(17L,"NARENDRA MODI"),new ResponseVO(23L,"NARENDRA MODI"),new ResponseVO(19L,"NARENDRA MODI"),new ResponseVO(25L,"NARENDRA MODI"));
//		ResponsesVO responsesVO=new ResponsesVO(responseVO);
//		String responses= testRestTemplate.postForObject(url,responsesVO ,String.class);
//		
//		
//	}
	
	
}
