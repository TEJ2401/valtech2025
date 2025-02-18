package assignment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import dao.Employee;
import dao.Employee.Gender;

class EmployeeTest {
	
	
	
	@Test
	void testAllMethods() {
		Employee obj1=Employee.builder().setId(2).setName("Tej").setAge(22).setSalary(15250).setGender(Gender.MALE).setLevel(20).setExp(0).build();
		Employee obj3=Employee.builder().setId(2).setName("Tej").setAge(22).setSalary(15250).setGender(Gender.MALE).setLevel(20).setExp(0).build();
		Employee.builder().setId(3).setName("Sagar").setAge(38).setSalary(20000).setGender(Gender.MALE).setLevel(5).setExp(10).build();
		Employee.builder().setId(4).setName("Nidhi").setAge(29).setSalary(30000).setGender(Gender.FEMALE).setLevel(11).setExp(12).build();
		Employee.builder().setId(5).setName("Deval").setAge(39).setSalary(45000).setGender(Gender.FEMALE).setLevel(13).setExp(14).build();
		Employee.builder().setId(6).setName("Pooja").setAge(32).setSalary(50000).setGender(Gender.FEMALE).setLevel(8).setExp(16).build();
		Employee.builder().setId(8).setName("Disha").setAge(40).setSalary(60000).setGender(Gender.MALE).setLevel(20).setExp(20).build();
		System.out.println("-----------------------------------------------");
		Employee obj2=obj1;
		assertSame(obj2,obj1);
		System.out.println("Object 1 is pointing to Object 2");
		assertEquals(obj1,obj2);
		System.out.println("The contents of Object 1 and Object 2 are equal");
		assertEquals(obj3,obj1);
		System.out.println("The contents of Object 3 and Object 1 are equal");
		assertNotSame(obj1,obj3);
		System.out.println("Object 1 is not pointing to Object 3");
//		Collections.sort(Employee.emplist);
		for(Employee employee:Employee.emplist) {
			System.out.println(employee);
		}
		System.out.println("-----------------------------------------------");
		System.out.println("Get Employees By Level");
		double salariesByLevel=Employee.getEmployeeByLevel(20);
		System.out.println("Sum By Level "+salariesByLevel);
		
		System.out.println("-----------------------------------------------");
//		List<Employee>emp2=Employee.getEmployeeByGender(Gender.MALE);
//		for(Employee employee:emp2) {
//			System.out.println(employee);
//		}
		System.out.println("-----------------------------------------------");
		double sum=Employee.getEmployeeByNameContents("tej");
		System.out.println("Sum of Employee by Name Contents "+sum);
		System.out.println("-----------------------------------------------");
		double emp4=Employee.getEmployeeByLevelAndGender(20,Gender.FEMALE);
		double emp5=Employee.emplist.stream().map(a->a.getSalary()).reduce(0,(a,b)->a+b);
		
		System.out.println(emp4);
		System.out.println("-----------------------------------------------");
		double sumOfSalaries=Employee.getSumOfAllEmployees();
		System.out.println(sumOfSalaries);
		System.out.println("-----------------------------------------------");
		Map<Gender,List<Employee>> mp=Employee.getEmployeeMap();
		double sumOfMaleEmp=mp.get(Gender.MALE).stream().mapToDouble(Employee::getSalary).sum();
		System.out.println("Sum Of Male Salaries "+sumOfMaleEmp);
		Map<Gender, Double> totalSalaryByGender = Employee.emplist.stream()
	            .collect(Collectors.groupingBy(
	                Employee::getGender, // Group by gender
	                Collectors.summingDouble(Employee::getSalary) // Aggregate by summing salaries
	            ));
		System.out.println(totalSalaryByGender);
		System.out.println(mp);
		
	}




}
