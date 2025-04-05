package spring.OrderManagementSystem;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

public class OrderManagementClient {

	public static void main(String[] args) {

		SessionFactory sesf = new AnnotationConfiguration().addAnnotatedClass(Orders.class).addAnnotatedClass(Item.class)
				.addAnnotatedClass(Customer.class).addAnnotatedClass(LineItems.class).buildSessionFactory();
		Session sess = sesf.openSession();
		Transaction tx = sess.beginTransaction();
		Customer c1 = new Customer();
		c1.setId(1);
		c1.setName("Tej");
		c1.setAge(22);
		Adress a = new Adress();
		a.setCity("Rajkot");
		a.setPincode(360001);
		a.setStreet("Akshar Road");
		c1.setAddress(a);
		c1.setPermanantAdress(a);
		Orders o1 = new Orders();
		o1.setCustomer(c1);
		Item i1 = new Item();
		i1.setId(1);
		i1.setName("Tennis Ball");
		i1.setDescription("Play Cricket");
		i1.setMaxQuantity(6);
		i1.setQuantity(6);
		i1.setReorder(4);
		Set s1 = new HashSet<LineItems>();
		LineItems l1 = new LineItems();
		l1.setId(1);
		l1.setItem(i1);
		l1.setQuantity(2);
		l1.setOrder(o1);
		s1.add(l1);
		o1.setLineitems(s1);
		i1.setLineitems(s1);
//		sess.persist(c1);
		sess.save(i1);
		sess.save(o1);

		tx.commit();
		sess.close();
		sesf.close();

	}

}
