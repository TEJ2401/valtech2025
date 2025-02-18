package day5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
class LocalDateCase {
	
	
	@Test
	void testDateTime() {
		LocalDateTime independenceDay=LocalDateTime.of(1947,8,15,9,15,10);
		System.out.println(independenceDay);
	}

	@Test
	void testTest() {
		
		LocalDate ld=LocalDate.of(1947,8,15);
			System.out.println(ld);
			LocalDate preIndependence=ld.minusDays(1);
			System.out.println(preIndependence);
			LocalDate postIndependenceDay= preIndependence.plusDays(2);
			System.out.println(postIndependenceDay);
			DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy");
			System.out.println(dtf.format(ld));
			System.out.println(LocalDate.parse("1947-08-15"));
			
				
	}

}
