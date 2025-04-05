package OrderManagementSystem;

public interface CustomerService {

	CustomerDAO getCustomerdao();

	void setCustomerdao(CustomerDAO customerdao);

	Customer checkForExistingCustomer(String name, int age, Adress adress, Adress permanantAdress);

	int addCustomer(Customer c);

	Customer getCustomerById(int id);

	void RemoveCustomer(int id);

	void updateCustomerStatus(Customer c);

}