package assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import assignment.Employee.Gender;

public class EmployeeService {
	
	public EmployeeService() {
		
	}

	public double getTotalSalariesByEmployeeLevel(int level,List<Employee>emp){
		double totalSalaries=emp.stream().filter(e->e.getLevel()==level).mapToDouble(Employee::getSalary).sum();
		return totalSalaries;
	}
	public double getEmployeeByGender(Gender gender,List<Employee> emplist){
		
		return emplist.stream().filter(e->e.getGender().equals(gender)).mapToDouble(Employee::getSalary).sum();
	}
	
	
	public double getEmployeesByNameContents(String name,List<Employee>emplist){
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
	
	public double getEmployeeByLevelAndGender(int level,Gender gender,List<Employee>emp){
		return emp.stream().filter(e->e.getGender().equals(gender) && e.getLevel()==level).mapToDouble(Employee::getSalary).sum();
	}
}
