package day2;

public interface SimpleInterest {
	
	public default double ComputeInterest(double principal,double rateOfInterest,double duration) {
		return principal*rateOfInterest *duration/100;
		
	}
	
}
