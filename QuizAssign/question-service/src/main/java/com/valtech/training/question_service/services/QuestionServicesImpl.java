package com.valtech.training.question_service.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.question_service.VO.QuestionVO;
import com.valtech.training.question_service.entities.Question;
import com.valtech.training.question_service.repo.QuestionRepo;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class QuestionServicesImpl implements QuestionService{

	
	@Autowired
	private QuestionRepo questionrepo;
	
	@Override
	public QuestionVO saveOrUpdate(QuestionVO questionVO) {
		Question question=questionrepo.save(questionVO.to(questionVO));
		return questionVO.from(question);
	}
	
	@Override
	public QuestionVO getQuestion(long id) {
		return QuestionVO.from(questionrepo.getReferenceById(id));
	}
	
	@Override
	public List<QuestionVO> getAllQuestions(){
		return QuestionVO.from(questionrepo.findAll());
	}
	
	@Override
	public List<Long> getAllQuestionsByTopic(String topic){
		return questionrepo.findByTopic(topic);

	}	
}
