import java.util.ArrayList;


import java.util.List;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAOImpl implements EmployeeDAO {

	static {
		try {
			Class.forName("org.postgresql.Driver");
		}
		catch(ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
	}
	private Connection getConnection()  throws SQLException{
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/training","postgres","postgres");
		
	}
	@Override
	public void save(Employee e) {
		try(Connection conn=getConnection()){
			PreparedStatement ps=conn.prepareStatement("INSERT INTO EMPLOYEE (NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,ID) VALUES(?,?,?,?,?,?,?) ");
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
		ps.setInt(7, e.getId());
	}

	@Override
	public void update(Employee e) {
		// TODO Auto-generated method stub
		try(Connection conn= getConnection()){
			PreparedStatement ps=conn.prepareStatement("UPDATE EMPLOYEE SET NAME= ?,AGE= ?,GENDER= ?,SALARY= ?,EXPERIENCE= ?,LEVEL=? WHERE ID=?");
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
		
		return Employee.builder().setId(rs.getInt(1)).setName(rs.getString(2)).setAge(rs.getInt(3)).setSalary(rs.getInt(5)).setLevel(rs.getInt(7)).setExp(rs.getInt(6)).setGender(Employee.Gender.valueOf(rs.getString(4))).build();
		
	}
	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		try(Connection conn=getConnection()){
			
		
		List<Employee>emps=new ArrayList<Employee>();
		PreparedStatement ps=conn.prepareStatement("select ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			emps.add(populateEmployee(rs));
			
		}
		return emps;
		}
		catch(Exception ex) {
			throw new RuntimeException(ex);
		}
//		return null;
	}

}
