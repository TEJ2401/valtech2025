package spring.OrderManagementSystem;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Entity
public class Item {
	
	
	@Id@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="accseq")
	@SequenceGenerator(name="accseq",sequenceName="acc_seq",allocationSize=1)
	private int id;
	
	private String name;
	private String description;
	private int quantity;
	private int reorder;
	private int maxQuantity;
	
	@OneToMany(mappedBy="item",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<LineItems> lineitems;
	
	public Item() {
	}
	
	public Item(String name, String description, int quantity, int reorder, int max_quantity) {
		super();
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.reorder = reorder;
		this.maxQuantity = max_quantity;
	}

	public Set<LineItems> getLineitems() {
		return lineitems;
	}
	public void setLineitems(Set<LineItems> lineitems) {
		this.lineitems = lineitems;
	}
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
	public int getMaxQuantity() {
		return maxQuantity;
	}
	public void setMaxQuantity(int max_quantity) {
		this.maxQuantity = max_quantity;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", quantity=" + quantity
				+ ", reorder=" + reorder + ", max_quantity=" + maxQuantity + ", orders="  + "]";
	}
	
	
	
	
}
