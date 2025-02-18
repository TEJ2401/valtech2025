package practiceudemya;

class Demo{
	
	static {
		
		System.out.println("Static Block Executed");
	}
}
public class StaticPractice {
	String brand;
	int price;
	static String name;
	
	static {
		name="Phone";
		System.out.println("In the Static Method");
	}
	
	public StaticPractice() {
		brand="";
		price=200;
		System.out.println("In the constructor");
	}
	
	public void show() {
		System.out.println();
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException {
//		StaticPractice sp1=new StaticPractice();
//		sp1.brand="Apple";
//		sp1.price=200;
//		StaticPractice.name="Mobile Phone";
//		
//		StaticPractice sp2=new StaticPractice();
//		System.out.println(StaticPractice.name);
		Class.forName("Demo");
	}
	
	
}
