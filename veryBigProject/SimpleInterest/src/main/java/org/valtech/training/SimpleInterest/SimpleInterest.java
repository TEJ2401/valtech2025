package org.valtech.training.SimpleInterest;

import com.valtech.training.arithmetic.Operation;

public class SimpleInterest {
	
	
	public int compute(int print,int rate,int time) {
		int product=Operation.MULTIPLY.perform(rate*print, time);
		
			return Operation.DIVIDE.perform(product,100);

	}
}
