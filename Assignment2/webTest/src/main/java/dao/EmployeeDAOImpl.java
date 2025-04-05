package dao;
import java.util.ArrayList;


import java.util.List;

import jakarta.servlet.ServletContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployeeDAOImpl implements EmployeeDAO {


	private String userName;
	private String password;
	private String dataUrl;
	
	private Connection getConnection()  throws SQLException{
		System.out.println(dataUrl);
		return DriverManager.getConnection(dataUrl,userName,"postgres");
		
	}
	public EmployeeDAOImpl(String userName, String password, String dataUrl) {
		super();
		this.userName = userName;
		this.password = password;
		this.dataUrl = dataUrl;
	}
	@Override
	public void save(Employee e) {
		try(Connection conn=getConnection()){
			PreparedStatement ps=conn.prepareStatement("INSERT INTO EMPLOYEE (NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,DEPTNO,ID) VALUES(?,?,?,?,?,?,?,?) ");
			setValuestoPrepareStatement(e, ps);
			int rowsAffected=ps.executeUpdate();
			System.out.println(rowsAffected);
		}
		catch(Exception ex) {
			throw new RuntimeException (ex);
		}
	}
	private void setValuestoPrepareStatement(Employee e, PreparedStatement ps) throws SQLException {
		
		ps.setString(1,e.getName());
		ps.setInt(2,e.getAge());
		ps.setString(3,e.getGender().name());
		ps.setInt(4, e.getSalary());
		ps.setInt(5, e.getExp());
		ps.setInt(6, e.getLevel());
		ps.setInt(8, e.getId());
		ps.setInt(7,e.getDeptno());
	}

	@Override
	public void update(Employee e) {
		// TODO Auto-generated method stub
		try(Connection conn= getConnection()){
			PreparedStatement ps=conn.prepareStatement("UPDATE EMPLOYEE SET NAME= ?,AGE= ?,GENDER= ?,SALARY= ?,EXPERIENCE= ?,LEVEL=?,DEPTNO=? WHERE ID=?");
			setValuestoPrepareStatement(e,ps);
			int rowsAffected=ps.executeUpdate();
			System.out.println("Rows Updated"+rowsAffected);
		}
		catch(Exception es) {
			throw new RuntimeException(es);
		}
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		try(Connection conn=getConnection()){
			PreparedStatement ps=conn.prepareStatement("DELETE FROM EMPLOYEE WHERE ID=?");
			ps.setInt(1, id);
			ps.executeQuery();
			
			
		}catch(Exception ex) {
			System.out.println("New RunTime Exception"+ex);
		}
		
	}

	@Override
	public Employee get(int id) {
		try(Connection conn=getConnection()){
			PreparedStatement ps=conn.prepareStatement("select ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,ID FROM EMPLOYEE WHERE ID=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("HI");
				Employee e=populateEmployee(rs);
				return e;
			}
			else {
				throw new RuntimeException("No Employee with Id "+id+"Fond");
			}
		}
		catch(Exception ex) {
			System.out.println("New RunTime Exception"+ex);
		}
		return null;
	}

	private Employee populateEmployee(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		
		return Employee.builder().setId(rs.getInt(1)).setName(rs.getString(2)).setAge(rs.getInt(3)).setSalary(rs.getInt(5)).setLevel(rs.getInt(7)).setExp(rs.getInt(6)).setGender(Employee.Gender.valueOf(rs.getString(4))).setDeptNo(rs.getInt(8)).build();
		
	}
	public List<Employee> getEmployeeByDepartment(int deptno){
		try(Connection conn=getConnection()){
			List<Employee> emp=new ArrayList<>();
			
			PreparedStatement ps=conn.prepareStatement("Select ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,DEPTNO FROM EMPLOYEE WHERE DEPTNO=? ");
			ps.setInt(1, deptno);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				emp.add(populateEmployee(rs));
				
			}
			return emp;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		try(Connection conn=getConnection()){
			
		
		List<Employee>emps=new ArrayList<Employee>();
		PreparedStatement ps=conn.prepareStatement("select ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,DEPTNO FROM EMPLOYEE");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			emps.add(populateEmployee(rs));
			
		}
		return emps;
		}
		catch(Exception ex) {
			throw new RuntimeException(ex);
			
		}
		
	}
}
