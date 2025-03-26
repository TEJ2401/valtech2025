package com.valtech.training.quiz_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.quiz_service.VO.QuestionVO;
import com.valtech.training.quiz_service.VO.QuizMasterVO;
import com.valtech.training.quiz_service.services.QuizServices;

@RestController
@RequestMapping("/api/v1/quizMaster")
public class QuizMasterController {

	@Autowired
	private QuizServices quizServicesImpl;
	
	
	
	@PostMapping("/")
	public QuizMasterVO createQuizMasterVO(@RequestBody QuizMasterVO quizMasterVO) {
		return quizServicesImpl.createQuiz(quizMasterVO);
	}
	
	
//	@GetMapping("/")
//	public List<QuizMasterVO> getQuizMasterVO() {
//		return quizServicesImpl.getAllQuizMasters();
//	}
	
}
