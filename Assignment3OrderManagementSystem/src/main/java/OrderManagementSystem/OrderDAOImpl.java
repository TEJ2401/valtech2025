package spring.OrderManagementSystem;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class OrderDAOImpl implements OrderDAO {
	
	SessionFactory sessionfactory;

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Override
	public int saveOrder(Orders order) {
			return (Integer)new HibernateTemplate(sessionfactory).save(order);
	}
	
	@Override
	public void updateOrder(Orders order) {
		new HibernateTemplate(sessionfactory).update(order);
	}
	
	@Override
	public Orders getOrder(int id) {
		
		return new HibernateTemplate(sessionfactory).load(Orders.class,id);
	}

	@Override
	public void deleteOrder(int id) {
		Orders order=getOrder(id);
		new HibernateTemplate(sessionfactory).delete(order);
	}
	
	
	
	@Override
	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		return new HibernateTemplate(sessionfactory).find("from orders o");
	}
	
	@Override
	public int getOrderCountByCustomerId(int id) {
			return new HibernateTemplate(sessionfactory).find("from orders o where o.customer_id=?",id).size();
	}
	
	
	
}
