package practiceudemya;

public class Human {
	private int age;
	private String name;
	
	public Human() {
		System.out.println("In Constructor");
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public static void main(String[] args) {
		Human obj=new Human();
		System.out.println(obj.getAge() + ":"+obj.getName());
		obj.setAge(11);
		obj.setName("Tej");
		System.out.println(obj.getName());
		
	}
}
