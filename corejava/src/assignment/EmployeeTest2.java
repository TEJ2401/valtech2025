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
	
	List<Employee>emps;
	private EmployeeService employeeService;
	
		//This method is run before each Test Case runs to initialize the List EveryTime
		@BeforeEach
		public void setEmployees() {
			Employee emp1=Employee.builder().setId(1).setName("Tej").setAge(22).setSalary(15250).setGender(Gender.MALE).setLevel(20).setExp(0).build();
			Employee emp2=Employee.builder().setId(2).setName("Tej").setAge(22).setSalary(15250).setGender(Gender.MALE).setLevel(20).setExp(0).build();
			Employee emp3=Employee.builder().setId(3).setName("Sagar").setAge(38).setSalary(20000).setGender(Gender.MALE).setLevel(5).setExp(10).build();
			Employee emp4=Employee.builder().setId(4).setName("Nidhi").setAge(29).setSalary(30000).setGender(Gender.FEMALE).setLevel(11).setExp(12).build();
			Employee emp5=Employee.builder().setId(5).setName("Deval").setAge(39).setSalary(45000).setGender(Gender.FEMALE).setLevel(13).setExp(14).build();
			Employee emp6=Employee.builder().setId(6).setName("Pooja").setAge(32).setSalary(50000).setGender(Gender.FEMALE).setLevel(8).setExp(16).build();
			Employee emp7=Employee.builder().setId(7).setName("Disha").setAge(40).setSalary(60000).setGender(Gender.FEMALE).setLevel(20).setExp(20).build();
			emps=Arrays.asList(emp1,emp2,emp3,emp4,emp5,emp6,emp7);
		}
		
		//This method will run before Each Test Case To supply the EmployeeService Object EveryTime
		@BeforeEach
		public void getEmpInstance() {
			employeeService=new EmployeeService();
		}
	
		
	@Test
	void testGetEmployeeByLevel() {
		double salariesByLevel1=employeeService.getTotalSalariesByEmployeeLevel(20,emps); // This has salary 90500
		double salariesByLevel2=employeeService.getTotalSalariesByEmployeeLevel(5, emps); //This has salary 20000
		assertEquals(90500,salariesByLevel1);
		assertEquals(20000,salariesByLevel2);
	}
	@Test
	void testGetEmployeeByNameContents() {
		double salariesByNameContents1=employeeService.getEmployeesByNameContents("Tej",emps); //This has salary 30500
		double salariesByNameContents2=employeeService.getEmployeesByNameContents("Nidhi", emps); //This has salary 30500
		assertEquals(30500,salariesByNameContents1);
		assertEquals(30000, salariesByNameContents2);
	}

	@Test
	void testGetEmployeeByLevelAndGender() {
		double salaryByLevelAndGender1=employeeService.getEmployeeByLevelAndGender(20,Gender.MALE,emps); //This has salary 90500
		double salaryByLevelAndGender2=employeeService.getEmployeeByLevelAndGender(11,Gender.FEMALE, emps); //This has salary 30000
		assertEquals(30500,salaryByLevelAndGender1);
		assertEquals(30000,salaryByLevelAndGender2);
	}

	@Test
	void testGetSumOfAllEmployees() {
		double salaryOfAllEmployees=employeeService.getSumOfAllEmployees(emps);
		System.out.println(salaryOfAllEmployees);
		
	}
	@Test
	void testHashCodeEquals() {
		
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
		assertNotEquals(emps.get(0),emps.get(1)); //This will return True as both this objects are different in terms of contents
		assertNotEquals(emps.get(4),emps.get(5)); // This will return True as both this objects are different in terms of contents
		emps.get(0).setId(2);   //Made 2 Objects exactly the Same to check if Equals Method works correctly
		assertEquals(emps.get(0),emps.get(1));  // Now this will evaluate to true
		
	}
	
	@Test 
	void getGenderMap(){
		Map<Gender,List<Employee>>mp=employeeService.getEmployeeMap(emps);
		//Prints Employees for Each Category
		for(Gender g:mp.keySet()) {
			System.out.println(g+" Employees ");
			for(Employee e:mp.get(g)) {
				System.out.println(e.toString());
			}
		}
	}
	

}
