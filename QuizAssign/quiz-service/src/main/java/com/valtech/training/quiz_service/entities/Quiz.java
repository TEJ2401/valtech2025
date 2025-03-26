package com.valtech.training.quiz_service.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Quiz")
public class Quiz {
	
	
	@Id@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "qz_seq")
	@SequenceGenerator(name="qz_seq",sequenceName = "qz_seq",allocationSize = 1)
	private long id;
	
	private String users;
	
	private String topic;
	
	private int noOfQuestions;
	
	@OneToMany(mappedBy = "quiz",cascade = CascadeType.ALL)
	private List<QuestionResult> questionResults;
	
	
	
	public String getUsers() {
		return users;
	}

	public void setUsers(String user) {
		this.users = user;
	}

	public List<QuestionResult> getQuestionResults() {
		return questionResults;
	}

	public void setQuestionResults(List<QuestionResult> questionResults) {
		this.questionResults = questionResults;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	public Quiz() {
		super();
	}


	public Quiz(long id, String user, String topic, int noOfQuestions) {
		super();
		this.id = id;
		this.users = user;
		this.topic = topic;
		this.noOfQuestions = noOfQuestions;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNoOfQuestions() {
		return noOfQuestions;
	}

	public void setNoOfQuestions(int noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}

	
	
	@Override
	public String toString() {
		return "QuizMaster [id=" + id + ", maximum_marks="  + ", noOfQuestions=" + noOfQuestions
				+ ", score=" + "]";
	}
	
	
}

