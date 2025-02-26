package practiceudemya;

class Demot{
	
	public static int io() {
		 return 1;
	}
}
interface tej{
	protected void meth() {
		System.out.println("Tej");
	}
}
class Promot extends Demot{
	
	public static int sub() {
		 super.io();
	}
	public int add(int a,int b) {
		return a+b;       
	}
	
	public double add(double a,double b,double c) {
		        return a+b+c; 
	}
	
	public double add(double a,double c) {
		return a+c;
	}
}

public class InyDemo {
	public static void main(String[] args) {
		tej a=new tej() {
			private void meth() {
				 System.out.println("Hi");
			}
		};
	}

}
