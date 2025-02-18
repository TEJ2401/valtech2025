package assignment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import dao.Employee;
import dao.Employee.Gender;

class EmployeeTest2 {

		Employee emp1=Employee.builder().setId(2).setName("Tej").setAge(22).setSalary(15250).setGender(Gender.MALE).setLevel(20).setExp(0).build();
		Employee emp2=Employee.builder().setId(2).setName("Tej").setAge(22).setSalary(15250).setGender(Gender.MALE).setLevel(20).setExp(0).build();
		Employee emp3=Employee.builder().setId(3).setName("Sagar").setAge(38).setSalary(20000).setGender(Gender.MALE).setLevel(5).setExp(10).build();
		Employee emp4=Employee.builder().setId(4).setName("Nidhi").setAge(29).setSalary(30000).setGender(Gender.FEMALE).setLevel(11).setExp(12).build();
		Employee emp5=Employee.builder().setId(5).setName("Deval").setAge(39).setSalary(45000).setGender(Gender.FEMALE).setLevel(13).setExp(14).build();
		Employee emp6=Employee.builder().setId(6).setName("Pooja").setAge(32).setSalary(50000).setGender(Gender.FEMALE).setLevel(8).setExp(16).build();
		Employee emp7=Employee.builder().setId(8).setName("Disha").setAge(40).setSalary(60000).setGender(Gender.MALE).setLevel(20).setExp(20).build();
		
		public double getEmployeeByLevel(int level,List<Employee>emp){
			double empl=emp.stream().filter(e->e.getLevel()==level).mapToDouble(Employee::getSalary).sum();
			return empl;
		}
		public double getEmployeeByGender(Gender gender,List<Employee> emplist){
			
			return emplist.stream().filter(e->e.getGender().equals(gender)).mapToDouble(Employee::getSalary).sum();
		}
		public double getEmployeeByNameContents(String name,List<Employee>emplist){
			List<Employee> emp= emplist.stream().filter(e->e.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
			return emp.stream().mapToDouble(Employee::getSalary).sum();
		}
		
		public double getSumOfAllEmployees(List<Employee> emplist) {
			return emplist.stream().mapToDouble(Employee::getSalary).sum();
		}
		public Map<Gender,List<Employee>> getEmployeeMap(List<Employee>emplist){
			 return emplist.stream()
	                 .collect(Collectors.groupingBy(e -> e.getGender()));
		}
		public List<Employee> addToList(){
			List<Employee>emp=new ArrayList<Employee>(Arrays.asList(emp1,emp2,emp3,emp4,emp5,emp6,emp7));
			return emp;
		}
		public double getEmployeeByLevelAndGender(int level,Gender gender,List<Employee>emp){
			return emp.stream().filter(e->e.getGender().equals(gender) && e.getLevel()==level).mapToDouble(Employee::getSalary).sum();
		}
	@Test
	void testGetEmployeeByLevel() {
		System.out.println("Inside the LEVEL METHOD");
		List<Employee>ls=new ArrayList<Employee>();
		double salariesByLevel=getEmployeeByLevel(20,ls);
		System.out.println();
		System.out.println("Sum By Level "+salariesByLevel);
		System.out.println("OUTSIDE the LEVEL METHOD");
	}

	@Test
	void testGetEmployeeByNameContents() {
		List<Employee>ls=addToList();
		double salariesByNameContents=getEmployeeByNameContents("Tej",ls);
		System.out.println("Sum Of Employees By Name Contents"+salariesByNameContents);
		System.out.println("OUTSIDE THE NAME METHOD");
	}

	@Test
	void testGetEmployeeByLevelAndGender() {
		System.out.println("Inside the GENDER-LEVEL METHOD");
		List<Employee> ls=addToList();
		double salaryByLevelAndGender=getEmployeeByLevelAndGender(20,Gender.MALE,ls);
		System.out.println("Salary By Gender"+salaryByLevelAndGender);
		System.out.println("Outside the GENDER-LEVEL METHOD");
	}

	@Test
	void testGetSumOfAllEmployees() {
		System.out.println("Inside the sumOFAllEmployees METHOD");
		List<Employee>ls=addToList();
		double salaryOfAllEmployees=getSumOfAllEmployees(ls);
		System.out.println("Sum of All Employees"+salaryOfAllEmployees);
		System.out.println("Inside the sumOfAllEmployees METHOD");
		
	}
	@Test
	void testHashCodeEquals() {
		int hash=emp1.hashCode();
		assertEquals(hash,emp1);
		assertEquals(emp1,emp2);
		assertNotSame(emp1,emp2);
		
	}
	
	@Test 
	void getGenderMap(){
		List<Employee>ls=addToList();
		Map<Gender,List<Employee>>mp=getEmployeeMap(ls);
		System.out.println(mp.keySet());
		System.out.println(mp.values());
	}
	

}
