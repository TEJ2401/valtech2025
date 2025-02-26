package day2;

@FunctionalInterface
public interface SimpleInterest {
	
	public default double ComputeInterest(double principal,double rateOfInterest,double duration) {
		return principal*rateOfInterest *duration/100;
		
	}
	public default double printSomething() {
		return 9.0;
	}
	void print();
	
}
