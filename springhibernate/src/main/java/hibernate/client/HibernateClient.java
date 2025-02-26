package hibernate.client;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import hibernate.Account;
import hibernate.Address;
import hibernate.AtmTx;
import hibernate.Car;
import hibernate.ChequeTx;
import hibernate.Customer;
import hibernate.TellerTx;
import hibernate.Tx;

public class HibernateClient {
	public static void main(String[] args) {
		SessionFactory sesFac=new AnnotationConfiguration().addAnnotatedClass(Car.class).addAnnotatedClass(Customer.class).addAnnotatedClass(Address.class).addAnnotatedClass(Tx.class).addAnnotatedClass(Account.class).addAnnotatedClass(AtmTx.class).addAnnotatedClass(TellerTx.class).addAnnotatedClass(ChequeTx.class).addAnnotatedClass(Car.class).addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session ses=sesFac.openSession();
		Transaction tx=ses.beginTransaction();
//	
//		Customer c=new Customer("Abc",26,true);
//		ses.save(c);
//		Account cus=(Account)ses.load(Account.class,1L);
//	
//		c.addAccount(cus);
		
//		Address a=new Address("Jaya","Blr",5600078);
//		c.setAdress(a);
//		a.setCustomer(c);
//		a.setId(c.getId());
//		ses.saveOrUpdate(a);
		
//		Account acc=(Account)ses.load(Account.class,1L);
//		Customer cus=(Customer)ses.load(Customer.class, 1L);
//	StudentId id=(StudentId)	ses.save(new Student(new StudentId(1,2025),"Tej","Chetan","CS",7861816993L),new StudentAddress("Somewehre","AHM",342323),new StudentAddress("NoWhere","Raj",563444)));
//			System.out.println(ses.load(Student.class, id));
//			ses.save(new Student(new StudentId(1,2025),"Het","Mitesh","Com",7861816993l,new StudentAddress("fehjh","vrwfjn","gfgff3r"),new StudentAddress("rvhv","r3h3b","rvbe3kjvb")))
//		Student s1=new Student(new StudentId(3,2025),"GHH","FEJFE","JFE",7861816993L,new StudentAddress("tej","ghg",360001),new StudentAddress("rtrt","rvrjwfvb",360001));
//		
//		StudentId id1=(StudentId)ses.save(s1);
		
//		
//		List<Tx> txs=ses.createQuery("from Tx t").list();
//		System.out.println(txs);
		
//		ChequeTx t=new ChequeTx(1000,100);
//		ChequeTx t1=new ChequeTx(1001,101);
//		ChequeTx t2=new ChequeTx(1002,103);
//		ChequeTx t3=new ChequeTx(1003,104);
//		
//		Account acc1=new Account(100000,"SB");
//		ses.save(acc1);
//		acc1.addTx(t);
//		acc1.addTx(t1);
//		acc1.addTx(t2);
//		acc1.addTx(t3);
//		txs.stream().forEach(t->acc1.addTx(t));
//		ses.createQuery("FROM Tx t").list().stream().forEach(t->System.out.println(t.toString()));
//		
	ses.createQuery("Select t.amount From Tx t JOIN t.account.customers c WHERE c.age> 25").list().stream().forEach(t->System.out.println(t));

//		Account acc1=new Account(500000,"CA");
//		Account acc2=new Account(300000,"SB");
//		Customer cus1=new Customer("DEF",32,false);
//		Customer cus2=new Customer("XYZ",36,false);
//		
//		ses.save(acc1);
//		ses.save(acc2);
//		ses.save(cus1);
//		ses.save(cus2);
//		
//		
//		cus.addAccount(acc);
//		cus.addAccount(acc1);
//		cus.addAccount(acc2);
//		cus1.addAccount(acc);
//		cus2.addAccount(acc); 
//		Car car=(Car)ses.load(Car.class,id);
//		car.setName("CV");
//		Car car1=(Car)ses.load(Car.class,id);
//		ses.save(new Car(1,"Honda","City",2025));
//		System.out.println(car.getClass().getName());
		tx.commit();

		ses.close();
		sesFac.close();
		
	}
}
