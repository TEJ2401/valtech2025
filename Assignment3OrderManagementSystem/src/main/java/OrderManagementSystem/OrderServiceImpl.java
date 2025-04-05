package spring.OrderManagementSystem;

import java.util.HashMap;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.criteria.Order;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import spring.OrderManagementSystem.Orders.STATUS;

@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class OrderServiceImpl implements OrderService {
	
	private CustomerService customerService;
	private Map<String,Integer> items;
	private InventoryService inventoryService;
	private ClassPathXmlApplicationContext context;
	
	public void setClassPathXmlApplicationContext(ClassPathXmlApplicationContext context) {
		this.context=context;
	}
	
	public CustomerService getCustomerService() {
		return customerService;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	public Map<String, Integer> getItems() {
		return items;
	}
	public void setItems(Map<String, Integer> items) {
		this.items = items;
	}
	public InventoryService getInventoryService() {
		return inventoryService;
	}
	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}
	public OrderDAO getOrderdaoimpl() {
		return orderdaoimpl;
	}
	public void setOrderdaoimpl(OrderDAO orderdaoimpl) {
		this.orderdaoimpl = orderdaoimpl;
	}
	public int getOrderFlag() {
		return orderFlag;
	}
	public void setOrderFlag(int orderFlag) {
		this.orderFlag = orderFlag;
	}

	private OrderDAO orderdaoimpl;
	private int orderFlag=0;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public int placeorder(String name,int age,Adress adress,Adress permanantAdress) {
		if(orderFlag==1) {
			return 0;
		}
		
		
		Customer cust=registerOrCheckExistingCustomer(name,age,adress,permanantAdress);
		if(cust==null) {
			System.out.println("You Cant Order,You are diosabled from Ordering");
			return 0;
		}
		Orders order=context.getBean(Orders.class);
		order.setStatus(STATUS.PENDING);
		for(String item:items.keySet()) {
			Item it=inventoryService.getItemByName(item);
			if(it.getQuantity()-items.get(item)<=it.getReorder()) {
				inventoryService.refillInventory(it.getId());
			}
			else {
				inventoryService.updateInventory(it.getId(),it.getQuantity()-items.get(item));
			}
			LineItems lineitem=context.getBean(LineItems.class);
			lineitem.setItem(inventoryService.getItemByName(item));
			lineitem.setOrder(order);
			lineitem.setQuantity(items.get(item));
			order.addLineItems(lineitem);
		}
		order.setCustomer(cust);
		int orderId=orderdaoimpl.saveOrder(order);
//		this.customer=null;
		this.items.clear();
		return orderId;
	}
	@Override
	public void reorder() {
		
	}
	@Override
	public void cancelorder() {
		items=null;
		return;
	}
	
	@Override
	public String getOrderStatus(int id) {
		Orders order=orderdaoimpl.getOrder(id);
		STATUS a=order.getStatus();
		
			switch(a) {
				case Orders.STATUS.PENDING:
					order.setStatus(Orders.STATUS.PROCESSING);
					orderdaoimpl.updateOrder(order);
					break;
				case Orders.STATUS.PROCESSING:
					order.setStatus(Orders.STATUS.SHIPPED);
					orderdaoimpl.updateOrder(order);
					
				case Orders.STATUS.SHIPPED:
					order.setStatus(Orders.STATUS.DELIVERED);
					orderdaoimpl.updateOrder(order);
					break;
				case Orders.STATUS.DELIVERED:
					break;
			}
			
			return a.toString();
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addToCart(String itemName,int quantity ) {
		Scanner sc=new Scanner(System.in);
		int itemId=inventoryService.getItemIdByName(itemName);
		int itemStock=inventoryService.CheckItemStock(itemId);
		Item it=(Item)inventoryService.getItemByName(itemName);
		if(quantity>it.getMaxQuantity()) {
			 System.out.println("The requested Item will not be present in this much amount");
			orderFlag=1;
		}
		else if(itemStock<quantity) {
				System.out.println("The Item"+itemName+"Is Out Of Stock");
				inventoryService.refillInventory(itemId);
				orderFlag=1;
				return;
			}

			if(items==null) items=new HashMap<String,Integer>();
			System.out.println(quantity);
			if(items.get(itemName)==null) {
				items.put(itemName,quantity);
			}
			else {
				items.put(itemName,items.get(itemName)+quantity);
			}
	
	}
	
	@Override
	public int getOrderCountByCustomer(int id) {
		return orderdaoimpl.getOrderCountByCustomerId(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Map<String,Object> Shop() {
		Scanner sc=new Scanner(System.in);
		Map<String,Object> customerOrder=new HashMap<String,Object>();
		System.out.println("Enter Customer Details to Proceed");
		int flag=0;
		String name=sc.nextLine();
		int age=sc.nextInt();
		String current_adress=sc.next();
		String permanant_adress=sc.next();
		String current[]=current_adress.split(",");
		String permanant[]=permanant_adress.split(",");
		Customer cust=new Customer();
		cust.setName(name);
		cust.setAge(age);
		cust.setAddress(new Adress(current[0],current[1],Integer.parseInt(current[2])));
		cust.setPermanantAdress(new Adress(permanant[0],permanant[1],Integer.parseInt(permanant[2])));
		customerOrder.put("Customer", cust);
		while(true) {
			System.out.println("Enter Item Name and Quantity Or Enter To Place Order");
			System.out.println("Enter 1 to write item name and quantity,2 to Place Order and 3 to Cancel The Order");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				String ItemName=sc.next();
				int quantity=sc.nextInt();
				addToCart(ItemName,quantity);
				break;
			case 2:
				flag=1;
				break;
			case 3:
				cancelorder();
				flag=1;
				break;
			}	
			if(flag==1){
				break;
			}
		}
		
		return customerOrder;
	}
	
	@Override
//	@Transactional(propagation=Propagation.REQUIRED)
	public Customer registerOrCheckExistingCustomer(String name,int age,Adress adress,Adress permanantAdress) {
		Customer cust=customerService.checkForExistingCustomer(name, age, adress, permanantAdress);
		
		if(cust!=null) {
			if(cust.getCustomerStatus()==Customer.CustomerStatus.DISABLED) {
				return null;
			}
			System.out.println("Existing");
			return cust;
		}
		else
		{
			Customer cs=context.getBean(Customer.class);
			cs.setName(name);
			cs.setAge(age);
			cs.setAddress(adress);
			cs.setPermanantAdress(permanantAdress);
			int customerId=customerService.addCustomer(cs);
			return cs;
		}

	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void registerCustomer(int id) {
		Customer cust=customerService.getCustomerById(id);	
	}

	
}
