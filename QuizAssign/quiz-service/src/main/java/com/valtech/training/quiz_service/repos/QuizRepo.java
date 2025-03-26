package com.valtech.training.quiz_service.repos;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.quiz_service.entities.QuestionResult;
import com.valtech.training.quiz_service.entities.Quiz;


@Repository
public interface QuizRepo extends JpaRepository<Quiz,Long > {
	
}
