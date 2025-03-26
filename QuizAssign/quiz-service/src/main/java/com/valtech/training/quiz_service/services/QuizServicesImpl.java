package com.valtech.training.quiz_service.services;

import java.util.ArrayList;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.quiz_service.VO.QuestionResultVO;
import com.valtech.training.quiz_service.VO.QuestionVO;
import com.valtech.training.quiz_service.VO.QuizMasterVO;
import com.valtech.training.quiz_service.VO.QuizQuestionVO;
import com.valtech.training.quiz_service.VO.QuizResultVO;
import com.valtech.training.quiz_service.VO.QuestionResultVO;
import com.valtech.training.quiz_service.VO.QuizVO;
import com.valtech.training.quiz_service.VO.ResponseVO;
import com.valtech.training.quiz_service.VO.ResponsesVO;
import com.valtech.training.quiz_service.entities.QuestionResult;
import com.valtech.training.quiz_service.entities.Quiz;

import com.valtech.training.quiz_service.repos.QuizMasterRepo;
import com.valtech.training.quiz_service.repos.QuizRepo;

import jakarta.ws.rs.core.Response;


@Service
@Transactional(propagation=Propagation.REQUIRED)
public class QuizServicesImpl implements QuizServices {

	
	
	@Autowired
	private QuizRepo quizRepo;
	
	@Autowired
	private QuestionClient questionClient;
	
	@Autowired
	private QuizMasterRepo questionMasterRepo;
	
	@Autowired
	private ResultClient resultClient;
	
	
	
	
	@Override
	public QuizMasterVO createQuiz(QuizMasterVO quizmaster) {
		
		Quiz quizMaster=quizRepo.save(quizmaster.to());
		
		List<Integer> questionByTopic=questionClient.getQuestionsByTopic(quizmaster.topic()).stream().limit(quizmaster.noOfQuestions()).collect(Collectors.toList());

		System.out.println("Question Size"+questionByTopic.size());
		for(Integer i: questionByTopic) {
			System.out.println(i);
		}
		System.out.println(questionClient.getAnswerById(26));
		List<QuestionResultVO> questions= questionByTopic.stream().map(w->QuestionResultVO.from(questionMasterRepo.save(new QuestionResult(0L,quizMaster,(Integer)w,null,questionClient.getAnswerById(w))))).collect(Collectors.toList()).stream().limit(quizmaster.noOfQuestions()).collect(Collectors.toList());	
		return QuizMasterVO.from(quizMaster);
		
		
		
	}
	
	@Override
	public List<QuizVO> getAllQuizes(){
		List<QuizVO> getAllQuizes= quizRepo.findAll().stream().map(w->takeQuizById(w.getId())).collect(Collectors.toList());
		return getAllQuizes;
		
	}
	
	@Override
	public QuizVO takeQuizById(long id) {
		
		QuizMasterVO quizMasterVO= QuizMasterVO.from(quizRepo.getReferenceById(id));
		
		List<QuestionResult> questions=questionMasterRepo.findAllByQuiz(quizMasterVO.to());
		List<QuizQuestionVO> question=questions.stream().map(w->questionClient.getQuestionById(w.getQuestionId())).collect(Collectors.toList());
		
		QuizVO quizVO=new QuizVO(id,quizMasterVO.topic(),quizMasterVO.user(),question);

		return quizVO;

	}
	

	@Override
	public String submitQuiz(long id,ResponsesVO responsesVO) {
		
		Quiz quizMaster=quizRepo.getReferenceById(id);
		List<ResponseVO> responses=responsesVO.responses();
		Map<Long,String>answers=responses.stream().collect(Collectors.toMap(w->(Long)w.questionId(),w->(String)w.answer()));
		System.out.println("ANSWERS"+answers);
		
		List<QuestionResult> questions= questionMasterRepo.findAllByQuiz(quizMaster);
		System.out.println("QUESTIONS"+questions);
		
		List<QuestionResultVO> questionId=questions.stream().map(w->QuestionResultVO.from( questionMasterRepo.save(new QuestionResult(w.getId(),quizMaster,w.getQuestionId(),w.getCorrectAnswer(),answers.get(w.getQuestionId()))))).collect(Collectors.toList());
		
		return "Your Quiz Has Been Taken successfully";
		
	}
	
	
	
	@Override
	public QuizResultVO getSubmittedAnswersForAssessment(long id){
		
		Quiz quiz=quizRepo.getReferenceById(id);
		List<QuestionResultVO> questionResultVO= questionMasterRepo.findAllByQuiz(quiz).stream().map(w->QuestionResultVO.from(w)).collect(Collectors.toList());
		QuizResultVO quizResultVO=new QuizResultVO(quiz.getId(),questionResultVO);
		
		return quizResultVO;
		
	}
	
	@Override
	public List<QuizResultVO> getAllSubmittedQuizesForAssessment(){
		
		List<QuizMasterVO> quizes=quizRepo.findAll().stream().map(w->QuizMasterVO.from(w)).collect(Collectors.toList());
		
		List<QuizResultVO> quizesResultVOs=quizes.stream().map(w->getSubmittedAnswersForAssessment(w.quizId())).collect(Collectors.toList());

		return quizesResultVOs;
		
	}
	
	
	
}
