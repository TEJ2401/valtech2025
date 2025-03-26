package com.valtech.training.assignment1.services;

import java.util.List;

import com.valtech.training.assignment1.VO.ItemVO;

public interface InventoryServices {


	ItemVO getItemById(long id);

	ItemVO refillInventory(long id);

	ItemVO createOrUpdateInventory(ItemVO item);

	List<ItemVO> getAllItems();

}