package com.valtech.training.question_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.question_service.VO.QuestionVO;
import com.valtech.training.question_service.services.QuestionService;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {

	@Autowired
	QuestionService questionService;
	
	
	@GetMapping("/")
	public List<QuestionVO> questionVO(){
		return questionService.getAllQuestions();
	}
	
//	@GetMapping("/{id}")
//	public QuestionVO getAllQuestions(@PathVariable long id){
//			return questionService.getQuestion(id);
//	}
	
	
	@GetMapping("/answers/{id}")
	public String getAnswerById(@PathVariable long id) {
		
		System.out.println("Answer"+questionService.getQuestion(id).answer());
		return questionService.getQuestion(id).answer();
	}
	
	@PostMapping("/")
	public QuestionVO createQuestion(@RequestBody QuestionVO questionVo) {
		return questionService.saveOrUpdate(questionVo);
	}


	@PostMapping("/{id}")
	public QuestionVO getAllQuestions(@PathVariable long id ) {
		return questionService.getQuestion(id);
	}
	
	@PutMapping("/{id}")
	public QuestionVO updateQuestions(@PathVariable long id,@RequestBody QuestionVO questionVo) {
		return questionService.saveOrUpdate(questionVo);
	}
	
	@GetMapping("/{topic}")
	public List<Long> updateQuestions(@PathVariable String topic) {
		
		return questionService.getAllQuestionsByTopic(topic);
		
	}
	
	
	
	
	
}
