package com.valtech.training.quiz_service.VO;

import com.valtech.training.quiz_service.entities.QuestionResult;

public record QuestionResultVO(long id,long quizId,long questionId,String submittedAnswer,String correctAnswer) {

	public static QuestionResultVO from(QuestionResult questionResult) {
		
		return new QuestionResultVO(questionResult.getId(),questionResult.getQuiz().getId(),questionResult.getQuestionId(),questionResult.getUserAnswer(),questionResult.getCorrectAnswer());
	}


}
