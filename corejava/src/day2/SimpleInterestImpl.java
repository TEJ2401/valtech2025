package day2;

import java.util.function.Consumer;

public class SimpleInterestImpl{
		public static void main(String[] args) {
			SimpleInterest si=new SimpleInterest();
			System.out.println(si.ComputeInterest(2000,12,3));
			
			SimpleInterest lamdaSi=( )->System.out.println("hi");
			lamdaSi.print();
			
		}

}
