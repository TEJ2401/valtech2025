package spring.tx;

import java.util.List;

public interface EmployeeService {

	EmployeeDAO getEmployeeDAO();

	void save(Employee e);

	void update(Employee e);

	void delete(int id);

	Employee get(int id);

	List<Employee> getAll();

}