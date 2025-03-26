package com.valtech.training.quiz_service.VO;

import java.util.List;

public record QuizVO(long QuizId,String topic,String User,List<QuizQuestionVO>questions) {
	
}
