package spring.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.tx.Employee;
import spring.tx.Employee.Gender;
import spring.tx.EmployeeService;

public class TxClient {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("tx2.xml");
		EmployeeService es=context.getBean(EmployeeService.class);
		es.getAll().forEach(e->System.out.println(e));
		System.out.println(es.get(1));
		System.out.println(es.getClass().getName());
		es.save(new Employee(30,"Riya",20,20,Gender.FEMALE,10000000,11));
		es.getAll().forEach(e->System.out.println(e));

//		es.update(new Employee(10,"Riya",10,10,Gender.FEMALE,1000000,10));

		context.close();
	}
}
