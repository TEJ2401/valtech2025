package spring.OrderManagementSystem;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Customer {

	@Id
	private int id;
	
	private String name;
	private int age;
	@Embedded
	private Adress address;
	@Embedded
	private Adress permanantAdress;
	
	@OneToMany(targetEntity=Order.class,mappedBy="customer",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
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
