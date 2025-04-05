package OrderManagementSystem;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Orders {

	
	@Id@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ordseq")
	@SequenceGenerator(name="ordseq",sequenceName="ord_seq",allocationSize=1)
	private int id;
	
	@ManyToOne(targetEntity=Customer.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="customer_id",referencedColumnName="id")
	private Customer customer;
	
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<LineItems> lineitems;
	
	public static enum STATUS{
		PENDING,PROCESSING,SHIPPED,DELIVERED;
	}
	@Enumerated(EnumType.STRING)
	private STATUS status;


	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public Set<LineItems> getLineitems() {
		return lineitems;
	}


	public void setLineitems(Set<LineItems> lineitems) {
		this.lineitems = lineitems;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}

	public void addLineItems(LineItems lineitem) {
		
		if(this.lineitems==null)lineitems=new HashSet<LineItems>();
		lineitems.add(lineitem);
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", items=" + lineitems + ", status=" + status + "]";
	}

}
