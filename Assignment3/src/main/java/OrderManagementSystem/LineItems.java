package OrderManagementSystem;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class LineItems {
	@Id@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="lineseq")
	@SequenceGenerator(name="lineseq",sequenceName="line_seq",allocationSize=1)
	private int id;

	@ManyToOne(targetEntity=Item.class,cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "item_id",referencedColumnName = "id")
	private Item item;
	
	
	@ManyToOne(targetEntity=Orders.class,cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id",referencedColumnName = "id")
	private Orders order;
	
	private int quantity;
	
	public LineItems() {
		super();
	}
	
	public LineItems(Item item, Orders order, int quantity) {
		this.item = item;
		this.order = order;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
