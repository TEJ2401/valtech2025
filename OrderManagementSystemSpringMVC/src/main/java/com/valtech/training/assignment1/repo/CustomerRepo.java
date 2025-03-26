package com.valtech.training.assignment1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.assignment1.entities.Customer;


@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
