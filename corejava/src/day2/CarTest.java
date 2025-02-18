package day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest implements Cloneable {
	
	@Test
	void testClone() throws Exception{
		
		Car car=new Car("Honda","City","XV",2024,7);
		Car car1=(Car)car.clone();
		assertEquals(car,car1);
		assertNotSame(car,car1);
	}

	@Test
	void testToString() {
		Car bmw=new Car("Honda","City","VX",2024,7);
		assertEquals("Honda City VX 2024 7",bmw.toString());
		bmw.setVariant("ZX");
		assertEquals("Honda City ZX 2024 7",bmw.toString());
		bmw.setVersion(9);
		assertEquals("Honda City ZX 2024 9",bmw.toString());

	}
	@Test
	void testhashCode() {
		Car bm=new Car("Honda","City","VX",2024,7);
		int hash=bm.hashCode();
		System.out.println(hash);
		assertEquals(hash,bm.hashCode());
		System.out.println();
		assertEquals(hash,new Car("Honda","City","VX",2024,7).hashCode());
		bm.setVariant("ZX");	
		System.out.println(bm.hashCode());
		assertEquals(hash,bm.hashCode());
		
//		bm.setYear(2021);
		bm.setVersion(9);
		assertNotEquals(hash,bm.hashCode());

	}

}
