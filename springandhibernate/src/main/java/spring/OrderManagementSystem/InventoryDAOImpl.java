package spring.OrderManagementSystem;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import spring.tx.Employee;

public class InventoryDAOImpl implements InventoryDAO {

	
	public DataSource getDatasource() {
		return datasource;
	}

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}

	private DataSource datasource;
	@Override
	public void save() {
		JdbcTemplate(datasource).
	}
	
	@Override
	public void update() {
		
	}
	
	@Override
	public void delete() {
		
		
	}
	@Override
	public void get(int id) {
		
	}
	
	@Override
	public void getAll() {
		
	}
	
	public static class InventoryRowMapper implements RowMapper<Item>{

		@Override
		public Item mapRow(ResultSet rs, int arg1) throws SQLException {
			Item item=new Item();
			item.set
			return 

		}
	}
	
}
