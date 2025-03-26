package com.valtech.training.quiz_service.VO;

import org.springframework.stereotype.Component;


public record QuizQuestionVO(long questionId,String question1,String option1,String option2,String option3,String option4) {
	
}
