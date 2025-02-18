package day2;

public class Spider extends Scooter {
	
	private static int totalCount=0;
	public Spider() {
		super();
		totalCount=super.returnNoOfScooters();
	}
	
	@Override
	public void printSomething() {
		System.out.println("Calling from the Child Class");
	}
	
	public static void main(String[] args) {
		Spider newscoot=new Spider();
		System.out.println(Spider.totalCount);
		Scooter newsc=new Spider();
		System.out.println(Spider.totalCount);
		System.out.println(Spider.noOfObjects);
		newsc.printSomething();
		newsc.add(23,34);
		
	}
	
	
	
	
}
