package com.valtech.training.result_service.VO;

import java.util.List;

public record QuizResultVO(long id,List<QuestionResultVO> questions) {

}