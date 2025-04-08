package com.valtech.training.result_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valtech.training.result_service.VO.ResultVO;
import com.valtech.training.result_service.services.ResultServices;
import com.valtech.training.result_service.services.ResultServicesImpl;

@Controller
@RequestMapping("/api/v1/results")
public class ResultController {

	
	@Autowired
	private ResultServices resultServices;
	
//	@GetMapping("/")
//	public List<ResultVO> getAllResults(){
//		
//	}
	
	@GetMapping("/{id}")
	public ResultVO checkQuiz(@PathVariable("id") long id ) {
		
		return resultServices.getResult(id);
		
	}
	

	
}
