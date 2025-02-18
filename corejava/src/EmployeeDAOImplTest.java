import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

import org.junit.jupiter.api.Test;


class EmployeeDAOImplTest {

	
	
	@Test
	void test() {
		EmployeeDAO dao=new EmployeeDAOImpl();
//		dao.save(Employee.builder().setId(2).setName("Tej").setAge(22).setSalary(15250).setLevel(20).setExp(0).build());

//		Employee e=new Employee(17,"Tej",23,250000,Employee.Gender.MALE,3,6);
		
		dao.delete(0);
	
	}

}
