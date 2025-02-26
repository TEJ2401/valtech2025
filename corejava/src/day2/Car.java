package day2;
import javax.persistance.Entity;
public class Car implements Cloneable{
 private String make;
 private String model;
 private int year;
 private int version;
 private String variant;
 @Version
 private int versiond;
 public String getVariant() {
	return variant;
}
public void setVariant(String variant) {
	this.variant = variant;
}
public Car() {
 }
public String getMake() {
	return make;
}
public static CarBuilder builder() {
	return new CarBuilder(new Car());
}
public Car(String make, String model,String variant, int year, int version) {
	super();
	this.make = make;
	this.model = model;
	this.variant=variant;
	this.year = year;
	this.version = version;
}
protected Object clone() throws CloneNotSupportedException{
	return super.clone();
}
public void setMake(String make) {
	this.make = make;
}
public void setVersiond(int versiond) {
	this.versiond=versiond;
}
public int 
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public int getVersion() {
	return version;
}
public void setVersion(int version) {
	this.version = version;
}

@Override
public String toString() {
	return new StringBuilder().append(make).append(" ").append(model).append(" ").append(variant).append(" ").append(year).append(" ").append(version).toString();
}
@Override
public boolean equals(Object obj) {
	//Object is a car
	Car c=(Car)obj;
	if(!(obj instanceof Car)) return false;
	Car car=(Car)obj;
	return year==car.year && version==car.version && variant.equals(car.variant) && model.equals(car.model) && make.equals(car.make);
	
}
@Override
public int hashCode() {
//	String c=toString()+"Car"
	return toString().concat("Car").hashCode();
}
 
 public static void main(String[] args) {
	Car honda=new Car("Honda","City","VX",2024,7);
	System.out.println(honda.toString());
	
}


 
 public static class CarBuilder {
	 private Car car;
	 public final int myvariabletej;
	 {
		 myvariabletej=10;
	 }
	 public CarBuilder(Car car) {
		 this.car=car;
	 }
	 public CarBuilder make(String make) {
		 car.setMake(make);
		 return this;
	 }
	 public CarBuilder model(String model) {
		 car.setModel(model);
		 return this;
	 }
	 public Car build() {
		 return car;
	 }
	 public CarBuilder variant(String variant) {
		 car.setVariant(variant);
		 return this;
	 }
	 public CarBuilder year(int year) {
		 car.setYear(year);
		 return this;
	 }
	 public CarBuilder version(int version) {
		 car.setVersion(version);
		 return this;
	 }
	 
 }
 
}
