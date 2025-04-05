package OrderManagementSystem;

public interface InventoryService {

	int CheckItemStock(int id);

	void refillInventory(int id);

	void createItem(String name, String description, int quantity, int reorder, int maximum);

	int getItemIdByName(String name);

	Item getItemByName(String name);
	
	void updateInventory(int id, int price);

}