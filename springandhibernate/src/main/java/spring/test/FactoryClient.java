package spring.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryClient {

		public static void main(String args[]) {
			ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("factory.xml");
			System.out.println(context.getBean("p1"));
			System.out.println(context.getBean("p1"));
			System.out.println(context.getBean("p1"));
			System.out.println(context.getBean("p1")==context.getBean("p1"));
			
		}
}
