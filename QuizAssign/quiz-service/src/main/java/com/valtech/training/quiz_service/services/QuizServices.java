package com.valtech.training.quiz_service.services;

import java.util.List;

import com.valtech.training.quiz_service.VO.QuestionVO;
import com.valtech.training.quiz_service.VO.QuizMasterVO;
import com.valtech.training.quiz_service.VO.QuizQuestionVO;
import com.valtech.training.quiz_service.VO.QuizResultVO;
import com.valtech.training.quiz_service.VO.QuizVO;
import com.valtech.training.quiz_service.VO.ResponsesVO;

public interface QuizServices {
	
	QuizMasterVO createQuiz(QuizMasterVO quizmaster);

	QuizVO takeQuizById(long id);

	String submitQuiz(long id,ResponsesVO responsesVO);

	List<QuizVO> getAllQuizes();

	QuizResultVO getSubmittedAnswersForAssessment(long id);

	List<QuizResultVO> getAllSubmittedQuizesForAssessment();

}