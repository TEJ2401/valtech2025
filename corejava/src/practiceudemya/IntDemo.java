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
		
		System.out.println(10+20+"Java");
		String s="Hello World";
		String s1="World";
		System.out.println(s==s1);
		
		
	}

}
