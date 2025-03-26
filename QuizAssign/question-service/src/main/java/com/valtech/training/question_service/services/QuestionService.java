package com.valtech.training.question_service.services;

import java.util.List;

import com.valtech.training.question_service.VO.QuestionVO;

public interface QuestionService {

	QuestionVO saveOrUpdate(QuestionVO questionVO);

	QuestionVO getQuestion(long id);

	List<QuestionVO> getAllQuestions();

	List<Long> getAllQuestionsByTopic(String topic);

}