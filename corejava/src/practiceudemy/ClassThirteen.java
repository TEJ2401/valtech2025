package practiceudemy;

import practiceudemya.ClaasOne;

public class ClassThirteen extends ClaasOne {

    public void printNumOfStud(ClaasOne t) {
        System.out.println(this.numOfStudents);
        System.out.println(t.noOfStudents);// Accessing the inherited protected variable
    }

    public static void main(String[] args,ClaasOne t) {
        // Creating an instance of ClaasOne
        ClaasOne one = new ClaasOne();
        int num=one.numOfStudents;
        // Accessing numOfStudents through the instance 'one'
        System.out.println(t.numOfStudents);  // This should work, accessing the protected member
    }
    
    
}

