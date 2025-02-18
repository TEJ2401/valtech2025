package practiceudemya;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.stream.Stream;

enum Status{
		Running,Failed,Pending,Success
}

interface Computer{
	public abstract void code();
	
}
//
//class Laptop implements Computer{
//	public void code() {
//		System.out.println("code,compile,run");
//	}
//}

class Desktop implements Computer{
	public void code() {
		System.out.println("code,compile and run fastrer");
	}
}
@FunctionalInterface
interface AnimalIndia{
	int show(int a);
	
}
class Student{
	int marks;
	String name;
	public Student(int marks,String name) {
		this.marks=marks;
		this.name=name;
	}
	public Student(String name) {
		this.name=name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [marks=" + marks + ", name=" + name + "]";
	}
	
}
class Teacher{
	static Student s1=new Student("Tej") {};
}
enum Laptop{
	MacBook(300000),HP(500000),ASUS(2500000),DELL(500000),AMD;
	private int price;
	private Laptop(int price) {
		this.price=price;
	}
	private Laptop() {
		
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}


public class IntDemo {
	public static void main(String[] args) {
		Status s=Status.Failed;
		System.out.println(s);
		
		Status[]ss=Status.values();
		for (Status sb : ss) {
			System.out.println(sb+" "+ sb.ordinal());
		}
		
		switch(s) {
		case Running:
			System.out.println("Running");
			break;
		case Failed:
			System.out.println("Failed");
			break;
		case Pending:
			System.out.println("Pending");
			break;
		case Success:
			System.out.println("Success");
			break;
		default:
			System.out.println("None OF THESE");
			
		}
		System.out.println(s.getClass().getSuperclass());
		System.out.println();
		int[] arr=new int[Laptop.values().length];
		Laptop[] lp=Laptop.values();
		int i=0;
		for(Laptop l:lp) {
			arr[i]=l.getPrice();
			i++;
		}
		for(Laptop l:lp) {
			System.out.println("Laptop"+l+"Price"+l.getPrice());
		}
		
		AnimalIndia a=new AnimalIndia() {
			public void show() {
				System.out.println("Animal India Printed");
			}
		};
		
		AnimalIndia b=z->{
			return z;
		};
		AnimalIndia c=z->z;
//		b.show();
//		a.show();
		Collection nums=new ArrayList();
		nums.add(2);
		nums.add(5);
		List<Integer>num=new ArrayList<Integer>();
		num.add(3);
		num.add(7);
		num.add(10);
		System.out.println(num.get(0));
		Set<Integer> newset=new HashSet<Integer>();
		newset.add(5);
		newset.add(10);
		newset.add(11);
		Collection<Integer>coll=new TreeSet<Integer>();
		coll.add(4);
		coll.add(9);
		coll.add(7);
		Iterator<Integer>values=coll.iterator();
//		for(int n:values) {
//			
//		}
		while(values.hasNext()) {
			int ab=values.next();
			System.out.println("Nums element"+ab);
			
		}
		Map<String,Integer>students=new HashMap<>();
		students.put("Navin",56);
		students.put("Harsh",67);
		students.put("Sushil",92);
		System.out.println(students.keySet());
		Set<String>student=students.keySet();
		Iterator<String>it=student.iterator();
		while(it.hasNext()) {
			String key=it.next();
			int marks=students.get(key);
			System.out.println("Key"+key+"Marks"+marks);
		}
		
		Comparator<Integer>com=new Comparator<Integer>() {
		
				
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(o2%10>o1%10) {
					return 1;
				}
				else {
					return -1;
				}
			}

		};
		num.sort(com);
		System.out.println(num);
		List<Student>stud=new ArrayList<>();
		stud.add(new Student(98,"Tej"));
		stud.add(new Student(99,"Param"));
		stud.add(new Student(99,"Harsh"));
		Comparator<Student> compt=(a1,a2)->a1.marks>a2.marks?1:-1;
		Comparator<Student>comp=new Comparator<>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				if(o1.marks>o2.marks){
					return 1;
				}
				else if(o1.marks<o2.marks) {
					return -1;
				}
				
				return o1.name.compareTo(o2.name);
			}
			
		};
		for(int n:num) {
			System.out.println("Element"+n);
		}
		num.forEach(n->System.out.println(n));
		Collections.sort(stud,compt);
		Collections.sort(stud,comp);
		System.out.println(stud);
		Consumer<Integer>con=(n)->System.out.println(n);
		List<Integer>ls=Arrays.asList(1,2,3,4);
		ls.forEach(con);
		
		Stream<Integer>s1=num.stream();
		Stream<Integer>s2=s1.filter(n->n%2==0);
		Stream<Integer>s3=s2.map(n->n*2);
		int result=s3.reduce(0,(d,e)->d+e);
		System.out.println(result);
//		s1.forEach(n->System.out.println(n));
		long time=System.currentTimeMillis();
		Student ss1=new Student(25,"Tej");
		Student ss2=new Student(30,"Dipti");
		List<Student>sss=Arrays.asList(ss1,ss2);
		int res=num.stream().mapToInt(nm->nm*2).sum();
//		int re=num.stream().mapToInt(student).sum();
		int rr=sss.stream().mapToInt(Student::getMarks).sum();
		System.out.println(res);
		System.out.println(System.currentTimeMillis()-time);
		
		List<String>name=Arrays.asList("Navin","Harsh","John");
		List<Student>studen=new ArrayList<>();
		studen=name.stream().map(named->new Student(25,named)).toList();
		System.out.println(studen);
		List<Student>sth=name.stream().map(Student::new).toList();
		
//		List<Student>
//		System.out.println(sth);
		System.out.println(rr);
		StringBuilder ssss=new StringBuilder("Tej Joshi");
		System.out.println(ssss.capacity());
		ssss.trimToSize();
		System.out.println(ssss.capacity());
		
	}

}
