package day2;
import java.util.Random;

public class Authenticator {

	 public long authenticate(String name,String pass) {
		 if("Scott".equals(name) && "Tiger".equals(pass)) {
			 return new Random().nextLong();
			 
		 }
		 throw new RuntimeException("Only Scott is allowed");
		 
	 }
}
