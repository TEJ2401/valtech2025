package OrderManagementSystem;

import java.util.List;

public interface OrderDAO {

	int saveOrder(Orders order);

	Orders getOrder(int id);

	void deleteOrder(int id);

	void updateOrder(Orders order);
	
	List<Orders> getAllOrders();

	int getOrderCountByCustomerId(int id);
}
