package day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GenericsTest {

	@Test
	void testInt() {
		Generics<Integer> p=new Generics<Integer>();
		p.setX(3);
		p.setY(4);
		System.out.println(p);
	
	
	}
	
	
	@Test
	void testDouble() {
		Generics<Integer> g=new Generics<Integer>();
		g.setX(3);
		g.setY(7);
		System.out.println(g);
		
	}
	
	@Test
	void testString() {
		Generics<String>p=new Generics<String>();
		p.setX("3");
		p.setY("5");
		System.out.println(p);
	}
	
	
	
}
