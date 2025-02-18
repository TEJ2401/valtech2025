package day2;

public class SimpleArithmetic implements arithmetic {

	
	@Override
	public double add(double a, double b) {
		return a+b;
	}

	@Override
	public double sub(double a, double b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public double mul(double a, double b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	public double div(double a, double b) {
		// TODO Auto-generated method stub
		return a/b;
	}
	
	
	public static void main(String args[]) {
		SimpleArithmetic a=new SimpleArithmetic();
		System.out.println(a.add(10, 20));
		System.out.println(a.sub(20,15));
		System.out.println(a.mul(20,5));
		System.out.println(a.div(100,20));
	}

	@Override
	public int div(int a, int b) {
		// TODO Auto-generated method stub
		return a/b;
	}
	
}
