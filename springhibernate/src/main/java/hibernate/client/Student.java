package hibernate.client;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.*;
@Entity
public class Student {
		
	@EmbeddedId
	private StudentId id;
	public Student(StudentId id, String name, String fatherName, String stream, long mobile) {
		super();
		this.id = id;
		this.name = name;
		this.fatherName = fatherName;
		this.stream = stream;
		this.mobile = mobile;
	}
	@Embedded()
	@AttributeOverrides({
		
		@AttributeOverride(name="street",column=@Column(name="home_street")),
		@AttributeOverride(name="city",column=@Column(name="home_city")),
		@AttributeOverride(name="pincode",column=@Column(name="home_pincode"))
	})
	private StudentAddress homeAdress;
	@Embedded()
	@AttributeOverrides({
		
		@AttributeOverride(name="street",column=@Column(name="current_street")),
		@AttributeOverride(name="city",column=@Column(name="current_city")),
		@AttributeOverride(name="pincode",column=@Column(name="current_pincode"))
	})
	private StudentAddress currentAdress;
	public Student(StudentId id, String name,String fatherName, String stream, long mobile,StudentAddress currentAdrees,StudentAddress homeAdress) {
		super();
		this.id = id;
		this.homeAdress = homeAdress;
		this.currentAdress = currentAdrees;
		this.name = name;
		this.fatherName = fatherName;
		this.stream = stream;
		this.mobile = mobile;
	}

	public StudentAddress getCurrentAdress() {
		return currentAdress;
	}

	public void setCurrentAdress(StudentAddress currentAdress) {
		this.currentAdress = currentAdress;
	}

	public StudentAddress getHomeAdress() {
		return homeAdress;
	}
	public void setHomeAdress(StudentAddress homeAdress) {
		this.homeAdress = homeAdress;
	}

	public Student() {};
	public StudentId getId() {
		return id;
	}
	public void setId(StudentId id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	private String name;
	private String fatherName;
	private String stream;
	private long mobile;
	
}
