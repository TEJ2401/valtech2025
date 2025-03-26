package com.valtech.training.result_service.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.result_service.VO.QuizResultVO;
import com.valtech.training.result_service.VO.QuizVO;
import com.valtech.training.result_service.VO.ResultVO;
import com.valtech.training.result_service.entities.Result;
import com.valtech.training.result_service.repo.ResultRepo;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class ResultServicesImpl implements ResultServices {

	
	@Autowired
	private ResultRepo resultRepo;
	
	@Autowired
	QuizClient quizClient;
		
	

	@Override
	public ResultVO getResult(long id) {
		
		QuizResultVO quizResultVO= quizClient.getQuizById(id);
	
		int score=quizResultVO.questionResults().stream().filter(w->w.submittedAnswer().equals(w.correctAnswer())).mapToInt(w->1).sum();
		
		return ResultVO.from(resultRepo.save(new Result(0L,id,(score/quizResultVO.questionResults().size())*100)));
		
	}
	
	
	public List<ResultVO> getAllResults(){
		
		List<QuizResultVO> allResults= quizClient.getAllQuizes();
		
		return allResults.stream().map(w->getResult(w.id())).collect(Collectors.toList());
	}
	
	
	
}
