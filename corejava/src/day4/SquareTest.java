package day4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SquareTest {

	@Test
	void test() {
		Square square=(x)->x*x;
		assertEquals(0,square.squareNow(0));
		assertEquals(16,square.squareNow(4));
		assertEquals(1,square.squareNow(1));
		assertEquals(1,square.squareNow(-1));
//		fail("Not yet implemented");
	}

}
