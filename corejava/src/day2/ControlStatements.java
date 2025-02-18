package day2;

public class ControlStatements {

	public void testIfElse(int a) {
		if(a%2==0) {
			System.out.println("Even");
		}
		else
		{
			System.out.println("Odd Number");
		}
	}
	public void testForIntegerArray(int []a) {
		for(int index=0;index<a.length;index++) {
			System.out.println(a[index]);
			
		}
	}
	public int add(int...a) {
		int sum=0;
		for(int i=0;i<a.length;i++) {
			sum+=a[i];
		}
		System.out.println(sum);
		return sum;
			
	}
	public void testSwitch(int a) {
		switch(a) {
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;
		case 3:
			System.out.println("Three");
			break;
		default:
			System.out.println("All Others");
		}
	}
	public static void main(String[] args) {
		ControlStatements cs= new ControlStatements();
		cs.testIfElse(3);
		cs.testIfElse(10);
		cs.testIfElse(67);
		cs.testForIntegerArray(new int[] {1,2,3});
		cs.testForIntegerArray(new int[] {4,5,6});
		cs.testSwitch(2);
		
		cs.add(1,2,3,4);
		cs.add(1,2,3,4,5);
		cs.add(1,2,3,4,5,6);
		
		
		}
	
}
