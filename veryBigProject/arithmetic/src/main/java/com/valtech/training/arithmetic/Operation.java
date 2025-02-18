package com.valtech.training.arithmetic;

public interface Operation {

		public static final Operation ADD=(a,b)->a+b;
		public static final Operation SUBTRACT=(a,b)->a-b;
		public static final Operation MULTIPLY=(a,b)->a*b;
		public static  final Operation DIVIDE=(a,b)->a/b;
		
		public int perform(int a,int b);
		
}



