package services;

import java.util.List;

import dao.Employee;
import dao.Employee.Gender;

public class EmployeeService {

		public List<Employee> sortByName(Boolean value,List<Employee> emps) {
			if(value==null || !value) {
				List<Employee> sortedEmps=emps.stream().sorted((o1,o2)->o1.getName().compareTo(o2.getName())).toList();
				return sortedEmps;
			}
			else {
				List<Employee> sortedEmps=emps.stream().sorted((o1,o2)->o2.getName().compareTo(o1.getName())).toList();
				return sortedEmps;
			}
				
		}
		
		public List<Employee> sortByAge(Boolean value,List<Employee>emps) {
			if(value==null || !value) {
				List<Employee> sortedEmps=emps.stream().sorted((o1,o2)->Integer.compare(o1.getAge(), o2.getAge())).toList();
				return sortedEmps;
			}
			else {
				List<Employee> sortedEmps=emps.stream().sorted((o1,o2)->Integer.compare(o2.getAge(),o1.getAge())).toList();
				return sortedEmps;
			}

		}
		
		public List<Employee> sortBySalary(Boolean value,List<Employee>emps) {
			if(value==null || !value) {
				List<Employee> sortedEmps=emps.stream().sorted((o1,o2)->Integer.compare(o1.getSalary(), o2.getSalary())).toList();
				return sortedEmps;
			}
			else {
				List<Employee> sortedEmps=emps.stream().sorted((o1,o2)->Integer.compare(o2.getSalary(),o1.getSalary())).toList();
				return sortedEmps;
			}

		}
		public List<Employee> sortByExperience(Boolean value,List<Employee>emps) {
			if(value==null || !value) {
				List<Employee> sortedEmps=emps.stream().sorted((o1,o2)->Integer.compare(o1.getExp(), o2.getExp())).toList();
				return sortedEmps;
			}
			else {
				List<Employee> sortedEmps=emps.stream().sorted((o1,o2)->Integer.compare(o2.getExp(),o1.getExp())).toList();
				return sortedEmps;
			}

		}
		public List<Employee> sortByLevel(Boolean value,List<Employee>emps) {
			if(value==null || !value) {
				List<Employee> sortedEmps=emps.stream().sorted((o1,o2)->Integer.compare(o1.getLevel(), o2.getLevel())).toList();
				return sortedEmps;
			}
			else {
				List<Employee> sortedEmps=emps.stream().sorted((o1,o2)->Integer.compare(o2.getLevel(),o1.getLevel())).toList();
				return sortedEmps;
			}

		}
		public List<Employee> sortByGender(Boolean value,List<Employee>emps) {
			if(value==null || !value) {
				List<Employee> sortedEmps=emps.stream().sorted((o1,o2)->o1.getGender().compareTo(o2.getGender())).toList();
				return sortedEmps;
			}
			else {
				List<Employee> sortedEmps=emps.stream().sorted((o1,o2)->o2.getGender().compareTo(o1.getGender())).toList();
				return sortedEmps;
			}

		}
		
		public List<Employee> sortById(Boolean value,List<Employee>emps){
			if(value==null || !value) {
				List<Employee> sortedEmps=emps.stream().sorted((o1,o2)->Integer.compare(o1.getId(),o2.getId())).toList();
				return sortedEmps;
			}
			else {
				List<Employee> sortedEmps=emps.stream().sorted((o1,o2)->Integer.compare(o2.getId(), o1.getId())).toList();
				return sortedEmps;
			}

		}	
		
		public List<Employee> searchById(List<Employee> ls,String operation,int searchValue){
			if("greater".equals(operation)) {
				ls=ls.stream().filter(o1->o1.getId()>searchValue).toList();
				return ls;
			}
			else if("lesser".equals(operation)) {
				ls=ls.stream().filter(o1->o1.getId()<searchValue).toList();
				return ls;
			}
			return ls.stream().filter(o1->o1.getId()==searchValue).toList();
		}
		
		public List<Employee> searchByName(List<Employee>ls,String operation,String searchValue){
			return ls.stream().filter(o1->o1.getName().equals(searchValue)).toList();
		}
		public List<Employee> searchByGender(List<Employee>ls,String operation,String searchValue){
			System.out.println("INSIDE GENDER");
			return ls.stream().filter(o1->o1.getGender()==Gender.valueOf(searchValue)).toList();
		}
		
		public List<Employee> searchByAge(List<Employee>ls,String operation,int searchValue){
			if("greater".equals(operation)) {
				ls=ls.stream().filter(o1->o1.getAge()>searchValue).toList();
				System.out.println("In the search operation"+ls);
				return ls;
			}
			else if("lesser".equals(operation)) {
				ls=ls.stream().filter(o1->o1.getAge()<searchValue).toList();
				return ls;
			}
			return ls.stream().filter(o1->o1.getAge()==searchValue).toList();
		}
		public List<Employee> searchBySalary(List<Employee>ls,String operation,int searchValue){
			if("greater".equals(operation)) {
				ls=ls.stream().filter(o1->o1.getSalary()>searchValue).toList();
				return ls;
			}
			else if("lesser".equals(operation)) {
				ls=ls.stream().filter(o1->o1.getSalary()<searchValue).toList();
				return ls;
			}
			return ls.stream().filter(o1->o1.getSalary()==searchValue).toList();
		}
		public List<Employee> searchByExperience(List<Employee>ls,String operation,int searchValue){
			if("greater".equals(operation)) {
				ls=ls.stream().filter(o1->o1.getExp()>searchValue).toList();
				return ls;
			}
			else if("lesser".equals(operation)) {
				ls=ls.stream().filter(o1->o1.getExp()<searchValue).toList();
				return ls;
			}
			return ls.stream().filter(o1->o1.getExp()==searchValue).toList();
		}
		public List<Employee> searchByLevel(List<Employee>ls,String operation,int searchValue){
			if("greater".equals(operation)) {
				ls=ls.stream().filter(o1->o1.getLevel()>searchValue).toList();
				return ls;
			}
			else if("lesser".equals(operation)) {
				ls=ls.stream().filter(o1->o1.getLevel()<searchValue).toList();
				return ls;
			}
			return ls.stream().filter(o1->o1.getLevel()==searchValue).toList();
		}
	
	
}
