package hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Address {
		@Id
		private long id;
		private String street;
		@OneToOne
		@PrimaryKeyJoinColumn
		private Customer customer;
		public long getId() {
			
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getStreet() {
			return street;
		}
		@Override
		public String toString() {
			return "Address [id=" + id + ", street=" + street + ", customer=" + customer + ", city=" + city
					+ ", zipcode=" + zipcode + "]";
		}
		public Address() {
			
		}
		public Address(String street, String city, int zipcode) {
			super();
			this.street = street;
			this.city = city;
			this.zipcode = zipcode;
		}
		public Customer getCustomer() {
			return customer;
		}
		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public int getZipcode() {
			return zipcode;
		}
		public void setZipcode(int zipcode) {
			this.zipcode = zipcode;
		}
		private String city;
		private int zipcode;
}
