package com.valtech.training.quiz_service.repos;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.quiz_service.entities.QuestionResult;
import com.valtech.training.quiz_service.entities.Quiz;

public interface QuizMasterRepo extends JpaRepository<QuestionResult,Long> {

	
	List<QuestionResult> findAllByQuiz(Quiz quiz);
	QuestionResult findById(long questionId);

}
