package com.valtech.training.result_service.VO;

import java.util.List;

public record QuizVO(long id,String topic,List<QuestionVO> questions) {
	
}
