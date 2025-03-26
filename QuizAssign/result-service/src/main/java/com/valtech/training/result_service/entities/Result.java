package com.valtech.training.result_service.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Result {

	@Id@GeneratedValue(generator ="res_seq",strategy= GenerationType.SEQUENCE)
	@SequenceGenerator(name = "res_seq",sequenceName = "res_seq",allocationSize = 1)
	private long id;
	
	private long quizId;
	
	private int score;

	private int percentage;
	
	
	public Result(long id, long quizId, int score) {
		super();
		this.id = id;
		this.quizId = quizId;
		this.score = score;
	}
	
	public Result() {
		super();
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getQuizId() {
		return quizId;
	}

	public void setQuizId(long quizId) {
		this.quizId = quizId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
		
	
}
