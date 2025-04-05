package OrderManagementSystem;

import java.sql.ResultSet;




import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import org.springframework.orm.hibernate3.HibernateTemplate;


public class InventoryDAOImpl implements InventoryDAO {

	private SessionFactory sessionfactory;
	private DataSource datasource;
	public DataSource getDatasource() {
		return datasource;
	}

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}
	
	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}


	@Override
	public void save(Item it) {
	 new HibernateTemplate(sessionfactory).save(it);
	}
	
	@Override
	public void update(int id,int quantity ) {
		Item it=get(id);
		System.out.println(it.getQuantity());
		it.setId(id);
		it.setQuantity(quantity);
		System.out.println("In here"+it.getId());
		System.out.println(it.getQuantity());
		new HibernateTemplate(sessionfactory).saveOrUpdate(it);
	}
	
	@Override
	public void delete(Item it) {
		new HibernateTemplate(sessionfactory).delete(it);
		
	}
	@Override
	public Item get(int id) {
	return new HibernateTemplate(sessionfactory).load(Item.class,id);
	}
	
	@Override
	public List<Item> getAll() {
		return new HibernateTemplate(sessionfactory).find("from Item i");
	}
	
	@Override
	public int getItemIdByName(String name) {
		String sql="from Item i where i.name= ?";
	List<Item> it=new HibernateTemplate(sessionfactory).find(sql,name);
	if(it.size()==0) {
		return 0;
	}
		return it.get(0).getId();
	}

	@Override
	public Item getItemByName(String name) {
		String sql="from Item i where i.name=?";
		List<Item>it=new HibernateTemplate(sessionfactory).find(sql,name);
		if(it.size()==0) {
			return null;
		}
		return it.get(0);
//		return (Item)new HibernateTemplate(sessionfactory).find(sql,name).get(0);
	}

	@Override
	public int getCount() {
		return new HibernateTemplate(sessionfactory).find("from Item i").size();
	}
	
}
