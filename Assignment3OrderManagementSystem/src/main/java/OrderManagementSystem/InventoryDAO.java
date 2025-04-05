package spring.OrderManagementSystem;

import java.util.List;

public interface InventoryDAO {

	void save(Item it);

	void delete(Item it);

	Item get(int id);

	List<Item> getAll();
	
	int getCount();

	int getItemIdByName(String name);
	
	Item getItemByName(String name);

	void update(int id, int price);
	
	

}