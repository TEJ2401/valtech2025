package day2;

public abstract class Scooter {
	
	public static int noOfObjects=0;
	
	public static int returnNoOfScooters() {
		noOfObjects++;
		return noOfObjects;
	}
	public void printSomething() {
		System.out.println("just checking whether the abstract class complete methods can be reached by the complete class");
	}
	public void add(int a,int b) {
		System.out.println("inside add int method");
	}
	public void add(int a,long b) {
		System.out.println("inside add long method");
	}
	
	
}
