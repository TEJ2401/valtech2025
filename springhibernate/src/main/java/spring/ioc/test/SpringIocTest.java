package spring.ioc.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.ioc.SimpleInterest;

class SpringIocTest {

	
	@Test
	void testParentChild() {
		ClassPathXmlApplicationContext parent=new ClassPathXmlApplicationContext("parent.xml");
		ClassPathXmlApplicationContext child=new ClassPathXmlApplicationContext(new String[] {"child.xml"},parent);
		System.out.println(child.getBean("line"));
		
	}
	
	
//	@Test
//	void test() {
//		ApplicationContext context=new ClassPathXmlApplicationContext("ioc.xml");
//		
//		SimpleInterest si=(SimpleInterest)context.getBean("si");
//		assertEquals(200,si.compute(200, 20, 5));
//		
//		System.out.println(context.getBean("p"));
//		System.out.println(context.getBean("p1"));
//		System.out.println(context.getBean("line"));
//	}
//	
}
