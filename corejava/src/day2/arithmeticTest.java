package day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class arithmeticTest {
	
	private SimpleArithmetic smp=new SimpleArithmetic();
	

	@Test
	void testAdd() {
		
		fail("Not yet implemented");
	}

	@Test
	void testSub() {
		assertEquals(10,smp.sub(20, 10));
//		fail("Not yet implemented");
	}

	@Test
	void testMul() {
		assertEquals(50,smp.mul(10, 5));
	}

	@Test
	void testDiv() {
		assertEquals(5,smp.div(6, 2));
	}
	@Test
	void testdivwithdouble() {
		assertEquals(1.666,smp.div(5., 3),0.0001);
		assertEquals(Double.POSITIVE_INFINITY,smp.div(5., 0),0.0001);
	}
	
	@Test
	void testDivWithInt() {
		assertEquals(2,smp.div(4,2));
		assertEquals(3,smp.div(7,2));
		
	}
	@Test
	void testDivWithIntDenomisZero() {
		
		try {
			smp.div(3, 0);
			fail("Exception was expected");
		}
		catch(Exception e){
			
		}
		
	}
	

}
