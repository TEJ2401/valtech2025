package com.valtech.training.question_service.VO;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.question_service.entities.Question;

public record QuestionVO(long id,String question,String option1,String option2,String option3,String option4,String answer,String Topic) {
	
	
	public static QuestionVO from(Question que) {
		return new QuestionVO(que.getId(),que.getQuestion(),que.getOption1(),que.getOption2(),que.getOption3(),que.getOption4(),que.getCorrectAnswer(),que.getTopic());
	}
	
	public Question to(QuestionVO qo) {
		return new Question(id,question,option1,option2,option3,option4,answer,Topic);
	}
	
	public static List<QuestionVO> from(List<Question> ls){
		
		return ls.stream().map(q->QuestionVO.from(q)).collect(Collectors.toList());
	}
}
