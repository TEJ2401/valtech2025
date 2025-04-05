package OrderManagementSystem;

import java.util.Map;

public interface OrderService {

	int placeorder(String name,int age,Adress adress,Adress permanantAdress);

	void reorder();

	void cancelorder();

	String getOrderStatus(int id);

	void addToCart(String itemName, int quantity);

	Map<String, Object> Shop();

	Customer registerOrCheckExistingCustomer(String name,int age,Adress adress,Adress permanantAdress);
	void registerCustomer(int id);

	int getOrderCountByCustomer(int id);

}