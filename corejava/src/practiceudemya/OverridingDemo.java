package practiceudemya;

class Animal{
	public void show() {
		System.out.println("I am an Animal");
	}
	public void config() {
		
	}
}

class Lion extends Animal{
		public void show() {
			System.out.println("I am an lion");
		}
		
		
}

public class OverridingDemo {
	public static void main(String[] args) {
		Animal animal=new Lion();
		animal.show();
	}
}
