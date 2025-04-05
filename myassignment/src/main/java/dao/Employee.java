package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Employee implements Comparable<Employee> {
	
	public static enum Gender{
		MALE,FEMALE,OTHER;
		
	}
	private int id;
	private String name;
	private int age;
	private int salary;
	private Gender gender;
	private int level;
	private int exp;
	private int deptno;
	
	
	public Employee() {}
	
	public Employee(int id, String name, int age, int salary, Gender male, int level, int exp) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.gender = male;
		this.level = level;
		this.exp = exp;
		
	}
	public Employee(int id, String name, int age, int salary, Gender gender, int level, int exp, int deptno) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.gender = gender;
		this.level = level;
		this.exp = exp;
		this.deptno = deptno;
	}

	
	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash("Office",age, exp, gender, id, level, name, salary,"Employee");
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return age == other.age && exp == other.exp && gender == other.gender && id == other.id && level == other.level
				&& Objects.equals(name, other.name) && salary == other.salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", gender=" + gender
				+ ", level=" + level + ", exp=" + exp + "]";
	}

	
	

	public static EmployeeBuilder builder() {
		return new EmployeeBuilder(new Employee());
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = Gender.valueOf(gender.toUpperCase());
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}

	
	public static class EmployeeBuilder{
		private Employee employee;
		public EmployeeBuilder(Employee employee) {
			this.employee=employee;
		}
		public EmployeeBuilder setId(int id) {
			employee.id=id;
			return this;
		}
		public EmployeeBuilder setName(String name) {
			employee.name=name;
			return this;
		}
		public EmployeeBuilder setAge(int age) {
			employee.age=age;
			return this;
		}
		public EmployeeBuilder setSalary(int salary) {
			employee.salary=salary;
			return this;
		}
		public EmployeeBuilder setGender(Gender male) {
			employee.gender=male;
			return this;
		}
		public EmployeeBuilder setLevel(int level) {
			employee.level=level;
			return this;
		}
		public EmployeeBuilder setExp(int exp) {
			employee.exp=exp;
			return this;
		}
		public EmployeeBuilder setDeptNo(int deptno) {
			employee.deptno=deptno;
			return this;
		}
		public Employee build() {

			return employee;
		}
		
	}
	@Override
	public int compareTo(Employee o) {
		int levelDiff=Integer.compare(o.salary, this.salary);
		if(levelDiff!=0)
			return levelDiff;
		int expDiff=Integer.compare(o.salary,this.salary);
		if(expDiff!=0)
			return expDiff;
		if(this.level!=o.level)
			return o.level-this.level;
		if(this.exp!=o.exp)
			return o.exp-this.exp;
		int genderDiff=o.gender.compareTo(this.gender);
		if(genderDiff!=0)
			return genderDiff;
		return Integer.compare(o.salary,this.salary);
	}

	
	
}
