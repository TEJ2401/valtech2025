package spring.OrderManagementSystem;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Item {
	
	
	@Id@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="accseq")
	@SequenceGenerator(name="accseq",sequenceName="acc_seq",allocationSize=1)
	private int id;
	
	private String name;
	private String description;
	private int quantity;
	private int reorder;
	private int max_quantity;
	
	@ManyToMany(targetEntity=LineItems.class,fetch=FetchType.EAGER)
	@JoinTable(name="Item_Order",joinColumns=@JoinColumn(name="item_id",referencedColumnName="id"),inverseJoinColumns=@JoinColumn(name="order_id",referencedColumnName="id"))
	private Set<Order>orders;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getReorder() {
		return reorder;
	}
	public void setReorder(int reorder) {
		this.reorder = reorder;
	}
	public int getMax_quantity() {
		return max_quantity;
	}
	public void setMax_quantity(int max_quantity) {
		this.max_quantity = max_quantity;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", quantity=" + quantity
				+ ", reorder=" + reorder + ", max_quantity=" + max_quantity + ", orders=" + orders + "]";
	}
	
	
	
	
}
