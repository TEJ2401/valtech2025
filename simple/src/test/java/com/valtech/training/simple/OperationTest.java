package com.valtech.training.simple;

import com.valtech.training.arithmetic.Operation;

import junit.framework.TestCase;

public class OperationTest extends TestCase {


		public void testAdd() {
			Operation add=(a,b)->a+b;
			add.perform(2, 4);
				assertEquals(5,Operation.ADD.perform(2, 3));
				assertEquals(11,Operation.SUBTRACT.perform(18, 7));
				assertEquals(14,Operation.MULTIPLY.perform(7, 2));
				
		}
}
