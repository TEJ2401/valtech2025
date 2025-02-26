package spring.ioc;

public class SimpleInterestImpl implements SimpleInterest {

	private Arithmetic arithmetic;
	
	@Override
	public int compute(int prin,int time,int rate) {
			return arithmetic.div(arithmetic.mult(prin, time*rate),100);
	}
	
	public void setArithmetic(Arithmetic arithmetic) {
		this.arithmetic=arithmetic;
	}
	
	
}
