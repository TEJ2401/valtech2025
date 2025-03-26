package com.valtech.training.quiz_service.VO;

import java.util.List;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import com.valtech.training.quiz_service.entities.Quiz;

import com.valtech.training.quiz_service.services.QuestionClient;

public record QuizMasterVO(long quizId,String user,String topic,int noOfQuestions) {
	

	public static QuizMasterVO from(Quiz q) {
		
		return new QuizMasterVO(q.getId(),q.getUsers(),q.getTopic(),q.getNoOfQuestions());
		
	}
	
	public Quiz to() {

		
		return new Quiz(quizId,user,topic,noOfQuestions);

		
		
	}
	
}
