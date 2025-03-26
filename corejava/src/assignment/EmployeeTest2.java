package assignment;

import static org.junit.jupiter.api.Assertions.*;
import assignment.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import assignment.Employee.Gender;

class EmployeeTest2 {
	

	private EmployeeService employeeService;
		

	@BeforeEach
	public void getEmpInstance() {
	employeeService=new EmployeeService();
	}
	
		
	@Test
	void testGetEmployeeByLevel() {
		double salariesByLevel1=employeeService.getTotalSalariesByEmployeeLevel(20); // This has salary 90500
		double salariesByLevel2=employeeService.getTotalSalariesByEmployeeLevel(5); //This has salary 20000
		assertEquals(90500,salariesByLevel1);
		assertEquals(20000,salariesByLevel2);
	}
	@Test
	void testGetEmployeeByNameContents() {
		double salariesByNameContents1=employeeService.getTotalSalariesByEmployeesByNameContents("Tej"); //This has salary 30500
		double salariesByNameContents2=employeeService.getTotalSalariesByEmployeesByNameContents("Nidhi"); //This has salary 30500
		assertEquals(30500,salariesByNameContents1);
		assertEquals(30000, salariesByNameContents2);
	}

	@Test
	void testGetEmployeeByLevelAndGender() {
		double salaryByLevelAndGender1=employeeService.getTotalSalaryByEmployeeByLevelAndGender(20,Gender.MALE); //This has salary 90500
		double salaryByLevelAndGender2=employeeService.getTotalSalaryByEmployeeByLevelAndGender(11,Gender.FEMALE); //This has salary 30000
		assertEquals(30500,salaryByLevelAndGender1);
		assertEquals(30000,salaryByLevelAndGender2);
	}

	@Test
	void testGetSumOfAllEmployees() {
		double salaryOfAllEmployees=employeeService.getSalarySumOfAllEmployees();
		System.out.println(salaryOfAllEmployees);
	}
	@Test
	void testHashCodeEquals() {
		List<Employee>emps=employeeService.getEmployees();
		int hash1=emps.get(0).hashCode();
		int hash2=emps.get(1).hashCode();
		assertNotEquals(hash1, hash2); //This will return false as the contents of the objects is different
		emps.get(1).setId(1); //Now made the id of the second object the same as the first object
		assertNotSame(emps.get(1),emps.get(0));
		int hash3=emps.get(1).hashCode(); //Then computed the hashcode again 
		assertEquals(hash1,hash3); //Now the hashcode of both the objects must be same and it will return true
		assertEquals(emps.get(0),emps.get(1));
		assertNotSame(emps.get(0),emps.get(1));
		Employee emp3=emps.get(1);
		assertSame(emp3,emps.get(1));
		assertNotEquals(emps.get(0).hashCode(),emps.get(3).hashCode()); //Just checking the hashcodes of completely different objects
		
	}
	
	
	
	@Test
	void testEqualsMethod() {
		List<Employee>emps=employeeService.getEmployees();

		assertNotEquals(emps.get(0),emps.get(1)); //This will return True as both this objects are different in terms of contents
		assertNotEquals(emps.get(4),emps.get(5)); // This will return True as both this objects are different in terms of contents
		emps.get(0).setId(2);   //Made 2 Objects exactly the Same to check if Equals Method works correctly
		assertEquals(emps.get(0),emps.get(1));  // Now this will evaluate to true
		
	}

	
	@Test
	void testCompareTo() {
		List<Employee>emps=employeeService.getEmployees();
		Collections.sort(emps);
		Employee emp=Employee.builder().setId(1).setName("Tej").setAge(22).setSalary(15250).setGender(Gender.MALE).setLevel(21).setExp(1).build();
		Employee emp1=Employee.builder().setId(1).setName("Tej").setAge(22).setSalary(15250).setGender(Gender.MALE).setLevel(20).setExp(0).build();
		Employee emp2=Employee.builder().setId(1).setName("Het").setAge(22).setSalary(15250).setGender(Gender.MALE).setLevel(20).setExp(2).build();
		System.out.println("Employee"+emp.compareTo(emp1));
		assertTrue(emp.compareTo(emp1)<1);
		assertTrue(emp1.compareTo(emp2)==1);
		
	}
	

	@Test 
	void getGenderMap(){
		Map<Gender,List<Employee>>mp=employeeService.getEmployeeMap();
		//Prints Employees for Each Category
		for(Gender g:mp.keySet()) {
			System.out.println(g+" Employees ");
			for(Employee e:mp.get(g)) {
				System.out.println(e.toString());
			}
		}
	}
	

}
