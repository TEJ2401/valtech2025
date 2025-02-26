package day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest implements Cloneable,Comparable<Car> {
	
//	@Test
//	void testClone() throws Exception{
//		
//		Car car=new Car("Honda","City","XV",2024,7);
//		Car car1=(Car)car.clone();
//		System.out.println("Both the objects are"+(car==car1));
//		assertEquals(car,car1);
//		assertSame(car,car1);
//	}
//
//	@Test
//	void testToString() {
//		Car bmw=new Car("Honda","City","VX",2024,7);
//		assertEquals("Honda City VX 2024 7",bmw.toString());
//		bmw.setVariant("ZX");
//		assertEquals("Honda City ZX 2024 7",bmw.toString());
//		bmw.setVersion(9);
//		assertEquals("Honda City ZX 2024 9",bmw.toString());
//
//	}
//	@Test
//	void testhashCode() {
//		Car bm=new Car("Honda","City","VX",2024,7);
//		int hash=bm.hashCode();
//		System.out.println(hash);
//		assertEquals(hash,bm.hashCode());
//		System.out.println();
//		assertEquals(hash,new Car("Honda","City","VX",2024,7).hashCode());
//		bm.setVariant("ZX");	
//		System.out.println(bm.hashCode());
//		assertEquals(hash,bm.hashCode());
//		
////		bm.setYear(2021);
//		bm.setVersion(9);
//		assertNotEquals(hash,bm.hashCode());
//
//	}
//
//	@Override
//	public int compareTo(Car o) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
	@Test
	void testClone() throws Exception{
		Car car=new Car("Honda","City","XV",2024,7);
		Car car2=(Car)car.clone();
		assertEquals(car,car2);
		assertNotSame(car,car2);
		assertEquals(car.hashCode(),car2.hashCode());
		
	}
}
