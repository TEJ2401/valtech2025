package spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PositiveParamsAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		// TODO Auto-generated method stub
		
		System.out.println("Inside Around Advice ....");
		Object [] args=mi.getArguments();
		for(int i=0;i<args.length;i++) {
			args[i]=Math.abs((Integer)args[i]);
		}
	return	mi.proceed();
		
	}

}
