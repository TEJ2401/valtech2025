package com.valtech.training.result_service.VO;

import com.valtech.training.result_service.entities.Result;

public record ResultVO(long id,long quizMasterId,long score,long percentage) {

	public static ResultVO from(Result save) {
		// TODO Auto-generated method stub
		return new ResultVO(save.getId(),save.getQuizId(),save.getScore(),save.getPercentage());
	}

}
