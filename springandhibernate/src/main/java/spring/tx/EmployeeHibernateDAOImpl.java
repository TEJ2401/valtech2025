package spring.tx;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.hibernate.*;

public class EmployeeHibernateDAOImpl implements EmployeeDAO {

	private SessionFactory sessionfactory;
	@Override
	public void save(Employee e) {
		new HibernateTemplate(sessionfactory).save(e);
		// TODO Auto-generated method stub
		
	}

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Override
	public void update(Employee e) {
		new HibernateTemplate(sessionfactory).update(e);

		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		new HibernateTemplate(sessionfactory).delete(get(id));

		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee get(int id) {
		// TODO Auto-generated method stub
	return	new HibernateTemplate(sessionfactory).load(Employee.class,id);

	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
	return	new HibernateTemplate(sessionfactory).find("from Employee e");
	

	}

	@Override
	public List<Employee> getEmployeeByDepartment(int deptno) {
		// TODO Auto-generated method stub
		return null;
	}

}
