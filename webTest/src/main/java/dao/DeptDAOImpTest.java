package dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import servlets.Dept;

class DeptDAOImpTest {

//	@Test
//	void testSave() {
//		d.save(new Dept(8,"computer science","Gandhinagar"));
//		System.out.println("DONE");
////		fail("Not yet implemented");
//	}
//
	@Test
	void testUpdate() {
		d.update(new Dept(1,"Machine Learning","Gandhinagar"));
//		fail("Not yet implemented");
	}
//
//	@Test
//	void testDelete() {
//		d.delete(4);
////		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGet() {
	
//		System.out.println(d.get(1));
////		fail("Not yet implemented");
//	}

	@Test
	void testGetAll() {
		d.save(new Dept(2,"Artificial Intelligence","Pune"));
		System.out.println(d.getAll());
		System.out.println(d.first());
//		fail("Not yet implemented");
	}

}
