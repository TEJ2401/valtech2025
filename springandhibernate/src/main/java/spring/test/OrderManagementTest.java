package spring.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.OrderManagementSystem.Adress;
import spring.OrderManagementSystem.Customer;
import spring.OrderManagementSystem.CustomerService;
import spring.OrderManagementSystem.InventoryService;
import spring.OrderManagementSystem.Item;
import spring.OrderManagementSystem.OrderService;
import spring.OrderManagementSystem.OrderServiceImpl;
import spring.OrderManagementSystem.Orders;

class OrderManagementTest {

	@Test
	@Order(1)
	void test() {
	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("springhibernate.xml");
	OrderService orderservices=context.getBean(OrderService.class);
	InventoryService inventoryservices=context.getBean(InventoryService.class);
	CustomerService customerServices=context.getBean(CustomerService.class);
	Adress current_adress=new Adress("Rajkot","Akshar Marg",360001);
	Adress permanant_adress=new Adress("Gandhinagar","Raysan",382007);
	orderservices.addToCart("RugbyBall",4);
	orderservices.addToCart("CricketSeasonBall",4);
	current_adress=new Adress("Baroda","Harni",350001);
	int OrderId=orderservices.placeorder("Het", 22, current_adress, permanant_adress);
	String status=orderservices.getOrderStatus(OrderId);
	status=orderservices.getOrderStatus(OrderId);
	System.out.println(status);
	assertEquals(12, inventoryservices.CheckItemStock(1));
	assertEquals(10,inventoryservices.CheckItemStock(2));
	context.close();
	}

	@Test
	@Order(2)
	void test2() {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("springhibernate.xml");
		OrderService orderservices=context.getBean(OrderService.class);
		InventoryService inventoryservices=context.getBean(InventoryService.class);
		Adress current_adress=new Adress("Rajkot","Akshar Marg",360001);
		Adress permanant_adress=new Adress("Gandhinagar","Raysan",382007);
		orderservices.addToCart("Rugby",4);
		orderservices.addToCart("Cricket",4);
		current_adress=new Adress("Baroda","Harni",350001);
		int OrderId=orderservices.placeorder("Het", 22, current_adress, permanant_adress);
//		String status=orderservices.getOrderStatus(OrderId);

		assertEquals(12,inventoryservices.CheckItemStock(8));
		assertEquals(10,inventoryservices.CheckItemStock(1));
		
		assertEquals(Orders.STATUS.PROCESSING, orderservices.getOrderStatus(OrderId));
		assertEquals(Orders.STATUS.SHIPPED, orderservices.getOrderStatus(OrderId));

		context.close();
	}
	
	@Test
	@Order(3)
	void test3() {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("springhibernate.xml");
		OrderService orderservices=context.getBean(OrderService.class);
		InventoryService inventoryservices=context.getBean(InventoryService.class);
		assertEquals(20,orderservices.getOrderCountByCustomer(10));
		
		Adress current_adress=new Adress("Rajkot","Akshar Marg",360001);
		Adress permanant_adress=new Adress("Gandhinagar","Raysan",382007);
		orderservices.addToCart("Rugby",4);
		orderservices.addToCart("Cricket",4);
		current_adress=new Adress("Baroda","Harni",350001);
		int OrderId=orderservices.placeorder("Het", 22, current_adress, permanant_adress);
		assertEquals(21,orderservices.getOrderCountByCustomer(10));

		
	}

}
