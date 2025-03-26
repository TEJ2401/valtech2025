package com.valtech.training.assignment1.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.assignment1.VO.ItemVO;
import com.valtech.training.assignment1.entities.Item;
import com.valtech.training.assignment1.repo.ItemRepo;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class InventoryServicesImpl implements InventoryServices {

	
	@Autowired
	private ItemRepo itemRepo;
	
	
	
	@Override
	public ItemVO createOrUpdateInventory(ItemVO item) {
	Item savedItem=itemRepo.save(item.to());
	return ItemVO.from(savedItem);
	}
	
//	public List<ItemVO> getAllItems(){
//		return itemRepo.findAll().stream().map(w->ItemVO.from(w)).collect(Collectors.toList());
//	}
	
	@Override
	public ItemVO getItemById(long id) {
		return ItemVO.from(itemRepo.getReferenceById(id));
		
	}

	@Override
	public ItemVO refillInventory(long id) {
		Item item=getItemById(id).to();

		item.setCurrentQuantity(item.getMaxQuantity());
		
		return createOrUpdateInventory(ItemVO.from(item));
	}
	
	@Override
	public List<ItemVO> getAllItems(){
		return  itemRepo.findAll().stream().map(w->ItemVO.from(w)).collect(Collectors.toList());
	}
	
}

