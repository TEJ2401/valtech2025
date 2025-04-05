package OrderManagementSystem;

import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientServices {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("springhibernate.xml");
		InventoryService inventoryservice=(InventoryService)context.getBean(InventoryService.class);
//		inventoryservice.createItem("TennisBall", "For Lone Tennis", 10, 5, 10);
//		inventoryservice.createItem("VolleyBall","Play VolleyBall", 10, 4, 10);
		OrderService orderservice=(OrderService)context.getBean(OrderService.class);
		Map<String,Object>customerOrder=orderservice.Shop();
		Customer c=(Customer)customerOrder.get("Customer");
		Orders o=(Orders)customerOrder.get("Orders");
		System.out.println(c.getId());
		System.out.println(o.getId());
		context.close();
		
		
	}
}
