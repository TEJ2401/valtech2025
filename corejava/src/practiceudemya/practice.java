package practiceudemya;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class practice {

	
	public static void main(String[] args) {
//
//		StringBuffer sb=new StringBuffer("Navin");
//		sb.append("Reddy");
//		System.out.println(sb.capacity());
//		System.out.println(sb);
//		String str=sb.toString();
		
		List<Integer>nums=Arrays.asList(4,5,6,7,8,9,3);
		Stream<Integer>sortedValues=nums.stream().sorted();
		sortedValues.forEach(n->System.out.println(n));
		
		StringBuilder st=new StringBuilder("Tej");
		System.out.println("Tej"+st.hashCode());
		st.append("ROHIT SHARMA");
		System.out.println("Capacity after Rohit Sharma "+st.capacity());
		System.out.println("After Rohit Sharma"+st.hashCode());
		st.append("MSDHONI");
		System.out.println("After MS DHONI"+st.hashCode());
		System.out.println(st.capacity());
		System.out.println("Capacity after MS DHONI "+st.capacity());
		StringBuilder sk=st.append("RAMHANUMANSITALAXMAN");
		System.out.println(st.capacity());
		System.out.println(st.hashCode());
		System.out.println(st==sk);
		
		String sj="MAHADEV";
		String sl="PARVATI";
		String som="MAHADEVPARVATI";
		StringBuilder so=new StringBuilder(sj.concat(sl))   ;
//		System.out.println(so==sl);
		System.out.println(so.equals(som));
		String kailash="MAHADEV"+"PARVATI";
		System.out.println(kailash);
		System.out.println(som==kailash);
		int size=10_000;
		List<Integer>ls=new ArrayList<>(size);
		Random ran=new Random();
		
		for(int i=0;i<=size;i++) {
			ls.add(ran.nextInt(100));
		}
		
		int sum3=(ls.stream().mapToInt(n->n*2)).sum();
		System.out.println("SUM3"+sum3);
		
	}
}
