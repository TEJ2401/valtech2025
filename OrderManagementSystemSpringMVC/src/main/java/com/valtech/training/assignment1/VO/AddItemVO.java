package com.valtech.training.assignment1.VO;

import java.util.ArrayList;
import java.util.List;

public class AddItemVO {

	private long id;
	
	private long quantity;

//	private List<Long> ids;
//	
//	private List<Long>quantities;
	
	
//	public List<Long> getIds() {
//		return ids;
//	}
//
//	public void setIds(List<Long> ids) {
//		this.ids = ids;
//	}
//
//	public List<Long> getQuantities() {
//		return quantities;
//	}
//
//	public void setQuantities(List<Long> quantities) {
//		this.quantities = quantities;
//	}
//	public void addQuantities(long quantity) {
//		if(quantities==null) quantities=new ArrayList<>();
//		this.quantities.add(quantity);
//	}

	
	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "AddItemVO [id=" + id + ", quantity=" + quantity + "]";
	}

	public AddItemVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddItemVO(long id, long quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
	
	
	
}
