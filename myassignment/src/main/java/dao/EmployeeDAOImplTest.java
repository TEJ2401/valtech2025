package dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dao.Employee.Gender;

class EmployeeDAOImplTest {

//	EmployeeDAOImpl empimp=new EmployeeDAOImpl();
	
	@Test
	void testSave() {
		empimp.save(new Employee(3,"Tej",22,222000,Gender.MALE,78,8,1));
	}

	@Test
	void testUpdate() {
		
		empimp.update(new Employee(1,"TEJ",23,250000,Gender.MALE,81,99,7));
//		fail("Not yet implemented");
	}

	@Test
	void testDelete() {

		
//		empimp.delete(1);
//		fail("Not yet implemented");
	}

	@Test
	void testGet() {
		System.out.println(empimp.getAll());
//		fail("Not yet implemented");
	}

	@Test
	void testGetAll() {
		System.out.println(empimp.get(1));
//		fail("Not yet implemented");
	}

}
