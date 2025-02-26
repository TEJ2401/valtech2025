package spring.OrderManagementSystem;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class InventoryServiceImpl {
	
	InventoryDAO inventory;
	private SessionFactory sessionfactory;

	public int CheckStock(int id) {
	
	Item item=(Item)new HibernateTemplate(sessionfactory).load(Item.class,id);
	return item.getQuantity();
		
	}
	
	public void removeInventory() {
	}
	
	public void addInventory() {
		
	}
	
	public void createInventory() {
		
	}
	
}
