package day2;

public class Outer {
	
	private int a;
	
	public void outerPrint() {
		System.out.println("Outer Print");
	}

		public class Inner{
			private int b;
			public void print() {
				System.out.println("Inner Print-A"+a+"Inner Print-B"+b);
				
			}
			public void addone() {
				a++;
				b++;
			}
			
		}
		public static class Inner1{
			private int b;
			public void orint(Outer a) {
				System.out.println("Inner Print-A"+a.a+"Inner Print-B"+b);
			}
		}
		private static abstract class Just{
			abstract void print();
		}
		public static class JustImpl extends Just{
			@Override
			void print() {
				System.out.println("My Job is to Just Print");
			}
		}
		
		public static void main(String[] args) {
			Outer o=new Outer();
			Outer.Inner i= o.new Inner();
			i.addone();
			i.print();
			Outer.Inner i1=o.new Inner();
			i1.addone();
			i1.print();
			
			Outer o1=new Outer();
			Inner1 a9=new Inner1();
			
			Outer.Inner a2=o1.new Inner();
			a2.addone();
			a2.print();
			JustImpl a3=new JustImpl();
			a3.print();
			Just j1=new Just() {
				@Override
				void print() {
					System.out.println("Just Class got completed");
				}
			};
			j1.print();
			
			
		}
}
