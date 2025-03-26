package com.valtech.training.assignment1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.assignment1.entities.Item;


@Repository
public interface ItemRepo extends JpaRepository<Item,Long> {

}
