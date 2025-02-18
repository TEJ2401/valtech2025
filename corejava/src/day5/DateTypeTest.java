package day5;


import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;



class DateTypeTest {

	@Test
	void test() throws ParseException {
		
		Date now=new Date();
		System.out.println(now);
 		Date independenceDay=new Date(47,7,15);
		System.out.println(independenceDay);
//		DateFormat df= new SimpleDateFormat();
		DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
		System.out.println(df.format(independenceDay));
		Date republicDay=df.parse("26-01-1950");
		System.out.println(republicDay);    
	
		/*
		 * 
		 * yyyy->year yy
		 * MM-> numeric Month MMM-> alpha
		 * dd -> day
		 * Hour-> hour
		 * Minute- mm
		 * Seconds - ss
		 * 
		 * 
		 */
		
		
	}

}
