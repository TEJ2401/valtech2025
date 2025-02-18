package practiceudemya;

abstract class Car{
	abstract public void drive();
	abstract public void fly();
	abstract public void playMusic();
}

class SwiftDzire extends Car{

	@Override
	public void drive() {
		// TODO Auto-generated method stub
		
		System.out.println("Swift is being driven");
		
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("Swift is being flown");
		
	}

	@Override
	public void playMusic() {
		// TODO Auto-generated method stub
		System.out.println("Swift is being played in Swift");
		
	}
	
}

public class AbstDemo{
	
	public static void main(String[] args) {
		Car c1=new SwiftDzire();
		c1.drive();
		c1.fly();
		c1.playMusic();
	}
		
}
