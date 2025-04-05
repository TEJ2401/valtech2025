package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletContext;
import servlets.Dept;

public class DeptDAOImp implements DeptDAO {
	
	private ServletContext sce;
	private String userName;
	private String password;
	private String dataUrl;
	
	public DeptDAOImp(ServletContext sce) {
		super();
		this.sce = sce;
	}
	private Connection getConnection()  throws SQLException{
		return DriverManager.getConnection(dataUrl,userName,password);
		
	}
	public DeptDAOImp(String userName, String password, String dataUrl) {
		super();
		this.userName = userName;
		this.password = password;
		this.dataUrl = dataUrl;
	}
	@Override
	public void save(Dept d) {
		try(Connection conn=getConnection()){
			PreparedStatement ps=conn.prepareStatement("INSERT INTO DEPARTMENT (NAME,LOCATION,DEPTNO) VALUES(?,?,?) ");
			setValuestoPrepareStatement(d, ps);
			int rowsAffected=ps.executeUpdate();
			System.out.println(rowsAffected);
	
		}
		catch(Exception ex) {
			throw new RuntimeException (ex);
		}
		
	}
	private void setValuestoPrepareStatement(Dept e, PreparedStatement ps) throws SQLException {
		
		ps.setInt(3,e.getId());
		ps.setString(1,e.getName());
		ps.setString(2, e.getLocation());
	}

	@Override
	public void update(Dept e) {
		// TODO Auto-generated method stub
		try(Connection conn= getConnection()){
			PreparedStatement ps=conn.prepareStatement("UPDATE DEPARTMENT SET NAME= ?,LOCATION= ? WHERE DEPTNO=?");
			setValuestoPrepareStatement(e,ps);
			int rowsAffected=ps.executeUpdate();
			System.out.println("Rows Updated"+rowsAffected);
		}
		catch(Exception es) {
			throw new RuntimeException(es);
		}
		
	}

	public Dept first() {
			try(Connection conn=getConnection()){
				PreparedStatement ps=conn.prepareStatement("SELECT DEPTNO,NAME,LOCATION from Department where DEPTNO=(SELECT MIN(DEPTNO) FROM DEPARTMENT )");
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					Dept d=populateEmployee(rs);
					return d;
				}
			}
			
			
			catch(Exception e) {
				e.printStackTrace();
			};
			return null;
		
	}


	public Dept last() {
		// TODO Auto-generated method stub
		try(Connection conn=getConnection()){
			PreparedStatement ps=conn.prepareStatement("SELECT DEPTNO,NAME,LOCATION from Department where DEPTNO=(SELECT MAX(DEPTNO) FROM DEPARTMENT )");
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				Dept d=populateEmployee(rs);
				return d;
			}
		}
		
		
		catch(Exception e) {
			e.printStackTrace();
		};
		return null;
		
	}


	public Dept next(int id) {

		try(Connection conn=getConnection()){
			System.out.println("In the Next Method");
			PreparedStatement ps=conn.prepareStatement("SELECT DEPTNO,NAME,LOCATION from Department where (DEPTNO=?)");
			ps.setInt(1, id+1);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				Dept d=populateEmployee(rs);
				System.out.println(d);
				return d;
			}
			else {
				Dept d=this.get(id);
				return d;
			}
		}
		
		
		catch(Exception e) {
			e.printStackTrace();
		};
		return null;
		
	}

	public Dept previous(int id) {

		try(Connection conn=getConnection()){
			
			PreparedStatement ps=conn.prepareStatement("SELECT DEPTNO,NAME,LOCATION from Department where DEPTNO=?");
			ps.setInt(1, id-1);
			ResultSet rs=ps.executeQuery();
			System.out.println("INSIDE RS METHOD");
			if(rs.next()) {
				System.out.println("INSIDE RS");
				Dept d=populateEmployee(rs);
				return d;
			}
			else {
				Dept d=this.first();
				return d;

			}
		}
		
		
		catch(Exception e) {
			e.printStackTrace();
		};
		return null;
		
	}


	@Override
	public void delete(int id) {

		try(Connection conn=getConnection()){
			PreparedStatement ps=conn.prepareStatement("DELETE FROM DEPARTMENT WHERE ID=?");
			ps.setInt(1, id);
			ps.executeQuery();
			
		}catch(Exception ex) {
			System.out.println("New RunTime Exception"+ex);
		}
		
	}
	private Dept populateEmployee(ResultSet rs) throws SQLException {
		return new Dept(rs.getInt(1),rs.getString(2),rs.getString(3));
		
	}

	@Override
	public Dept get(int id) {

		try(Connection conn=getConnection()){
			PreparedStatement ps=conn.prepareStatement("Select DEPTNO,NAME,LOCATION from Department where DEPTNO=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				Dept e=populateEmployee(rs);
				return e;
			}
			else {
				System.out.println("No Element of the provided ID exists");
			}
		}
		catch(Exception e) {
			System.out.println("New Runtime Exception "+e);
		}
		return null;
	}

	@Override
	public List<Dept> getAll() {

		try(Connection conn=getConnection()){
			List<Dept> ls=new ArrayList<>();
			PreparedStatement ps=conn.prepareStatement("Select DEPTNO,NAME,LOCATION FROM Department");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ls.add(populateEmployee(rs));
			}
			return ls;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
