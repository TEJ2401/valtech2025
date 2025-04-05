package spring.OrderManagementSystem;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation=Propagation.REQUIRED)
public class InventoryServiceImpl implements InventoryService {
	
	private InventoryDAO inventorydao;
	public InventoryDAO getInventorydao() {
		return inventorydao;
	}
	public void setInventorydao(InventoryDAO inventorydao) {
		this.inventorydao = inventorydao;
	}
	private SessionFactory sessionfactory;
	
	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}
	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int CheckItemStock(int id) {
	Item item=inventorydao.get(id);
	return item.getQuantity();
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void refillInventory(int id) {
		Item it=inventorydao.get(id);
		inventorydao.update(id,it.getMaxQuantity());
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateInventory(int id,int quantity) {
			inventorydao.update(id,quantity);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void createItem(String name,String description,int quantity,int reorder,int maximum) {
		inventorydao.save(new Item(name,description,quantity,reorder,maximum));
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int getItemIdByName(String name) {
		return inventorydao.getItemIdByName(name);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Item getItemByName(String name) {
		return inventorydao.getItemByName(name);
	}
	
}
