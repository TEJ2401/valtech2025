package spring.aop;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.aop.MethodBeforeAdvice;

public class CounterAdvice implements MethodBeforeAdvice {

	
	private Map<String,Integer>counters;
	
	public void any() {
		counters=new HashMap<String,Integer>();
	}
	
	public void any1() {
		System.out.println("Counters"+counters);
	}
	
	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("Method ="+arg0 +"With Args = "+ Arrays.toString(arg1));
		String methodName=arg0.getName();
		if(counters.containsKey(methodName)) {
			counters.put(methodName, counters.get(methodName)+1);
		}
		else {
			counters.put(methodName,1);
		}
		
	}

}
