package day2;

public class SimpleInterestImpl implements SimpleInterest{
		public static void main(String[] args) {
			SimpleInterest si=new SimpleInterestImpl();
			System.out.println(si.ComputeInterest(2000,12,3));
			SimpleInterest lamdaSi=(double p,double r,double d)-> p*d*r/100;
			
			Consumer<SimpleInterest> si=(double p,double r,double d)-> p*d*r/100;
		}
}
