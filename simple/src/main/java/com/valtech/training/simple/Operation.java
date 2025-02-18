package com.valtech.training.simple;

public interface Operation {

		Operation ADD=(a,b)->a+b;
		Operation SUBTRACT=(a,b)->a-b;
		Operation MULTIPLY=(a,b)->a*b;
		Operation DIVIDE=(a,b)->a/b;
		
		int perform(int a,int b);
		
}



