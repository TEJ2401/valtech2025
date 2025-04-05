package OrderManagementSystem;

import java.util.List;

public interface CustomerDAO {


	int addCustomer(Customer c);
	
	void removeCustomer(Customer c);
	
	void updateCustomer(Customer c);
	
	Customer checkForExistingCustomer(String name, int age, Adress adress, Adress permanantAdress);

	Customer getCustomerById(int id);
	
	List<Customer> getAll();
	
	int getCount();
	
	
	


}
