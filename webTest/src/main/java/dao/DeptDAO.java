package dao;

import java.util.List;

import servlets.Dept;

public interface DeptDAO {
	void save(Dept d);
	void update(Dept e);
	void delete(int id);
	Dept get(int id);
	List<Dept> getAll();
	Dept next(int id);
	Dept previous(int id);
	Dept first();
	Dept last();
	
}
