package spring.OrderManagementSystem;

import java.util.Set;

import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class LineItems {

	@Id
	private int id;

	@ManyToMany()
	private Item item;
	
	private Order order;
	
	private int quantity;
	
	
}
