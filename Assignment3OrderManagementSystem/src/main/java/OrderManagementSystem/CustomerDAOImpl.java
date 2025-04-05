package spring.OrderManagementSystem;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class CustomerDAOImpl implements CustomerDAO {

	private SessionFactory sessionfactory;
	
	
	@Override
	public int addCustomer(Customer c) {
		return (Integer)new HibernateTemplate(sessionfactory).save(c);
	}
	
	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Override
	public void removeCustomer(Customer c) {
		new HibernateTemplate(sessionfactory).delete(c);
	}
	
	
	@Override
	public Customer getCustomerById(int id) {
		
		return new HibernateTemplate(sessionfactory).load(Customer.class,id);
	
	}
	
	@Override
	public Customer checkForExistingCustomer(String name,int age,Adress adress,Adress permanantAdress) {
		String sql="from Customer c where c.name=? and c.age=?";
		List<Customer>cust=(List<Customer>)new HibernateTemplate(sessionfactory).find(sql,name,age);
		if(cust.size()==0) {
			return null;
		}
		return (Customer)new HibernateTemplate(sessionfactory).find(sql,name,age).get(0);
	}

	
	@Override
	public void updateCustomer(Customer c) {
		new HibernateTemplate(sessionfactory).update(c);
	}
	
	
	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return new HibernateTemplate(sessionfactory).find("from customerEntity c");
	}

	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return new HibernateTemplate(sessionfactory).find("from customerEntity c").size();
	}
	
	
}
