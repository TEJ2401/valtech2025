package OrderManagementSystem;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO customerdao;
	

	@Override
	public CustomerDAO getCustomerdao() {
		return customerdao;
	}

	@Override
	public void setCustomerdao(CustomerDAO customerdao) {
		this.customerdao = customerdao;
	}

	@Override
	public Customer checkForExistingCustomer(String name,int age,Adress adress,Adress permanantAdress) {
		return customerdao.checkForExistingCustomer(name, age, adress, permanantAdress);
	}

	@Override
	public int addCustomer(Customer c) {
		return (Integer)customerdao.addCustomer(c);
	}

	@Override
	public Customer getCustomerById(int id) {
		return customerdao.getCustomerById(id);
	}
	
	@Override
	public void RemoveCustomer(int id) {
	}
	
	@Override
	public void updateCustomerStatus(Customer c) {
		customerdao.updateCustomer(c);
	}
	

}
