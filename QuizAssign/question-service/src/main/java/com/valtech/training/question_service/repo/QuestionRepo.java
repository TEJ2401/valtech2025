package com.valtech.training.question_service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.valtech.training.question_service.entities.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Long> {

	@Query("Select q.id from Question q where q.topic= :topic ORDER BY random()")
	List<Long> findByTopic(String topic);

	
}
