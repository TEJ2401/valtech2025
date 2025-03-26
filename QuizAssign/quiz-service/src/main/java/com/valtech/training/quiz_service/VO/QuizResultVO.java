package com.valtech.training.quiz_service.VO;

import java.util.List;

public record QuizResultVO(long quizId,List<QuestionResultVO> questions) {

	
}
