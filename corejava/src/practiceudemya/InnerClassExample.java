package practiceudemya;

class Outer{
	private int age;
	public void show() {
		System.out.println("in the show method");
	}
	
	class B{
		public void config() {
			System.out.println("In the Inner Class Method");
		}
	}
	static class C{
		public void conf() {
			System.out.println("In the static Inner Class");
		}
	}
}
class AnonymousExample{
	public void show() {
		System.out.println("MARTIAL ARTS IS GREAT,LEARN IT");
	}
}



public class InnerClassExample {
		public static void main(String[] args) {
			Outer obj=new Outer();
			obj.show();
			Outer.B inner=obj.new B();
			Outer.C innstat=new Outer.C();
			
			AnonymousExample example=new AnonymousExample() {
				public void show() {
					System.out.println("I LUV CRICKET AND WHOLE OF INDIA DOES");
				}
			};
			
			example.show();
			
			
		}
}


