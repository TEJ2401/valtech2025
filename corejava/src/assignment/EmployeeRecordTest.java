package assignment;
import assignment.Employee.Gender;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import assignment.Employee.Gender;;

class EmployeeRecordTest {

	@Test
	void test() {
		EmployeeRecord er1=new EmployeeRecord(1,"ABC",23,Gender.MALE,12000,5,2);
		EmployeeRecord er2=new EmployeeRecord(1,"ABC",23,Gender.MALE,12000,5,2);
		assertEquals("ABC",er1.name());
		assertEquals(23,er1.age());
		assertEquals(12000,er1.salary());
		assertEquals(5,er1.experience());
		assertEquals(2,er1.level());
		
		assertEquals(er1.hashCode(),er2.hashCode());
		EmployeeRecord er3=new EmployeeRecord(1,"ABC",23,Gender.MALE,1200,5,2);
		assertFalse(er1.hashCode()==er3.hashCode());
//		assertEquals(er1,er3);
		assertNotEquals(er1,er3);
		assertEquals(2500,er1.computeBonus());
		System.out.println(er1.computeBonus());
//		fail("Not yet implemented");
	}

}
