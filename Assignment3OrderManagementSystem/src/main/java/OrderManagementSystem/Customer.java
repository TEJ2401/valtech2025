package spring.OrderManagementSystem;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="customerEntity")
public class Customer {

	@Id@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="custseq")
	@SequenceGenerator(name="custseq",sequenceName="cust_seq",allocationSize=1)
	private int id;
	
	private String name;
	private int age;

	@Embedded()
	@AttributeOverrides({
		
		@AttributeOverride(name="street",column=@Column(name="street")),
		@AttributeOverride(name="city",column=@Column(name="city")),
		@AttributeOverride(name="pincode",column=@Column(name="pincode"))
	})
	private Adress address;
	@Embedded()
	@AttributeOverrides({
		
		@AttributeOverride(name="street",column=@Column(name="home_street")),
		@AttributeOverride(name="city",column=@Column(name="home_city")),
		@AttributeOverride(name="pincode",column=@Column(name="home_pincode"))
	})
	private Adress permanantAdress;
	
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Orders>orders;
	
	public enum CustomerStatus{
		ENABLED,DISABLED
	}
	
	
	private CustomerStatus customerStatus;
	
	
	public CustomerStatus getCustomerStatus() {
		return customerStatus;
	}
	public void setCustomerStatus(CustomerStatus customerStatus) {
		this.customerStatus = customerStatus;
	}
	public Customer() {

	}	
	public Customer( String name, int age, Adress address, Adress permanantAdress, Set<Orders> orders) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.permanantAdress = permanantAdress;
		this.orders = orders;
	}

	public Set<Orders> getOrders() {
		return orders;
	}
	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Adress getAddress() {
		return address;
	}
	public void setAddress(Adress address) {
		this.address = address;
	}
	public Adress getPermanantAdress() {
		return permanantAdress;
	}
	public void setPermanantAdress(Adress permanantAdress) {
		this.permanantAdress = permanantAdress;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", permanantAdress="
				+ permanantAdress + "]";
	}
	
	
}
