package spring.OrderManagementSystem;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

public class Order {

	@Id@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="accseq")
	@SequenceGenerator(name="accseq",sequenceName="acc_seq",allocationSize=1)
	private int id;
	@ManyToOne(targetEntity=Customer.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="customer_id",referencedColumnName="id")
	private Customer customer;
	
	@ManyToMany(targetEntity=LineItems.class,fetch=FetchType.LAZY,mappedBy="orders")
	private List<List<Item>>items;
	
	
	@Enumerated(EnumType.STRING)
	private STATUS status;
	
	
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", items=" + items + ", status=" + status + "]";
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public Set<Item> getItems() {
		return items;
	}



	public void setItems(Set<Item> items) {
		this.items = items;
	}



	public STATUS getStatus() {
		return status;
	}



	public void setStatus(STATUS status) {
		this.status = status;
	}



	public static enum STATUS{
		PENDING,PROCESSING,SHIPPED,DELIVERED;
	}
}
