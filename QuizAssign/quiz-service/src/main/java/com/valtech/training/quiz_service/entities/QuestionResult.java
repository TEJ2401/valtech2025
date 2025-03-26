package com.valtech.training.quiz_service.entities;

import java.util.List;
import java.util.Set;
import java.util.jar.Attributes.Name;


import com.valtech.training.quiz_service.VO.QuestionVO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;



@Entity
public class QuestionResult {

	
	@Id@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="qr_seq")
	@SequenceGenerator(name = "qr_seq",sequenceName = "qr_seq",allocationSize = 1)
	private long id;
	
	
	@ManyToOne(targetEntity = Quiz.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "quiz_Id",referencedColumnName = "id")
	private Quiz quiz;
	
	
	public Quiz getQuiz() {
		return quiz;
	}


	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}


	public String getUserAnswer() {
		return userAnswer;
	}


	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}


	public String getCorrectAnswer() {
		return correctAnswer;
	}


	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	private long questionId;	

	private String userAnswer;
	
	private String correctAnswer;
	
	
	
	public QuestionResult() {}
	

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public QuestionResult(long id, Quiz quiz, long questionId, String userAnswer, String correctAnswer) {
		super();
		this.id = id;
		this.quiz = quiz;
		this.questionId = questionId;
		this.userAnswer = userAnswer;
		this.correctAnswer = correctAnswer;
	}
	
	
}
