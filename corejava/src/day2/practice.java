package day2;

class Students{
	
	private int marks;
	private int rollNo;
	
	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	private Students(int marks,int rollNo) {
		this.marks=marks;
		this.rollNo=rollNo;
	}
	
	public int add(int b,int c,int...a) {
		return a.length;
	}
	
}

class BrightStudent extends Students{
	private String Name;

	public BrightStudent(String name) {
		super(setMarks(10), setMarks(10));
		Name = name;
	}
	
}


public class practice {
	
}
