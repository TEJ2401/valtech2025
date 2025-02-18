package practiceudemya;

import java.util.Objects;

public class ClaasOne {
	
	private int a;
	private int b;
    protected int numOfStudents = 20; // protected instance variable

    protected void printNoOfStudents() {
        System.out.println("There are 19 Students in the class");
    }
    
    public ClaasOne(int a,int b) {
    	this.a=a;
    	this.b=b;
    }
    public static void main(String[] args) {
		
    	
    	ClaasOne a1=new ClaasOne(2,3);
    	ClaasOne a2=new ClaasOne(2,3);
    	ClaasOne a3=a2;
    	boolean result=a1.equals(a2);
    	System.out.println(result);
    	System.out.println(a2.equals(a3));
    	System.out.println(a3.hashCode());
    	System.out.println(a2.hashCode());
    	System.out.println(a1.hashCode());
    	System.out.println(a2==a3);
    	
	}

	@Override
	public int hashCode() {
		return Objects.hash(a, b, numOfStudents);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClaasOne other = (ClaasOne) obj;
		return a == other.a && b == other.b && numOfStudents == other.numOfStudents;
	}
}
