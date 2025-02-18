package day1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnimalTest {

	@Test
	void testDog() {
		Dog dog=new Dog();
		showBehaviour(dog);
//		fail("Not yet implemented");
	}

	@Test
	void testCat() {
		showBehaviour(new Cat());
//		fail("Not yet implemented");
	}

	@Test
	void testTiger() {
		showBehaviour(new Tiger());
//		fail("Not yet implemented");
	}
	private void showBehaviour(Animal a) {
		a.makeSound();
		a.eat();
		a.sleep();
		
	}

}
