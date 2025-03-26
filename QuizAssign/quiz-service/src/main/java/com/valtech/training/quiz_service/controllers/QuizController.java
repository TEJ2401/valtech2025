package com.valtech.training.quiz_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.quiz_service.VO.QuizResultVO;
import com.valtech.training.quiz_service.VO.QuizVO;
import com.valtech.training.quiz_service.VO.ResponsesVO;
import com.valtech.training.quiz_service.services.QuizServices;

import jakarta.ws.rs.Path;

import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/quizes")
public class QuizController {

	
	@Autowired
	private QuizServices quizServices;
	
	@GetMapping("/assess")
	public List<QuizVO> getAllQuizesForAssessment(){
		return quizServices.getAllQuizes();
	}
	
	@GetMapping("/assess/{id}")
	public QuizResultVO getSubmittedQuizForAssessment(@PathVariable long id){
		return quizServices.getSubmittedAnswersForAssessment(id);
	}
	
	@GetMapping("/{id}")
	public QuizVO takeQuiz(@PathVariable long id) {
		
		return quizServices.takeQuizById(id);
	}
	
	
	@PostMapping("/{id}")
	public String submitQuiz(@PathVariable long id,@RequestBody ResponsesVO responses) {
		
	return quizServices.submitQuiz(id, responses);

	}
	
//	
//	
//	@PostMapping("/{id}")
//	public int getScore(@PathVariable long id) {
//		return quizServices.getQuizResult(id);
//		
//	}
	
	
	
	
//	@PutMapping("/{id}")
//	public int checkQuizById(@PathVariable long id) {
//		
//		return quizServices.getQuizById(id);		
//		
//	}
	
	
	
	
}
