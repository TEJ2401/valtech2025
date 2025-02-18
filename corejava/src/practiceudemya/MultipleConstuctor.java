package practiceudemya;
class A{
	public A() {
		super();
		System.out.println("in A");
	}
	public A(int n) {
		super();
		System.out.println("in A int");
	}
}

class B extends A{
	public B() {
//		super(3);
		System.out.println("in B");
	}
	public B(int n) {
		this();
		System.out.println("in int b constructor");
	}
}


class C extends B{
	
	public C() {
		System.out.println("in C");
	}

}

public class MultipleConstuctor {
		public static void main(String[] args) {
//			B obj=new B(3);
			B obj1=new B(3);
		}
}
