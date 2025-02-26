package com.valtech.training.unittesting;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ArithmeticImplTest {
	
	ArithmeticImpl arithmetic;
	@BeforeAll
	public static void adassd() {
		System.out.println("Before All");
	}
	@BeforeEach
	public void getInstance() {
		arithmetic=new ArithmeticImpl();
	}
	
	@ParameterizedTest(name="Add With CSV Source A={0} B={1} Result={2}")
	@CsvFileSource(files="data.csv")
	void testAddWithCSVFile(int a,int b,int res) {
			assertEquals(res,arithmetic.add(a, b));
	}
	
	
	static Stream<Arguments> addArgumentsProvider(){
		return Stream.of(Arguments.of(2,3,5),Arguments.of(-1,2,1),Arguments.of(5,-5,0));
	}
	
	
	@ParameterizedTest(name="Add with Method Source A={0} B={1} Res={2}")
	@MethodSource(value="addArgumentsProvider")
	void testAddWithMethodSource(int a,int b,int res) {
		assertEquals(res,arithmetic.add(a, b));
	}
	
	
	@ParameterizedTest(name="Add With CSV Source A={0} B={1} Result={2}")
	@CsvSource(value={"2,3,5","-1,3,2","0,3,3","-1,-1,-2"})
	void testAddWithCSV(int a,int b,int res) {
			assertEquals(res,arithmetic.add(a, b));
	}
	
	@ParameterizedTest(name="Add with Multiple Values")
	@ValueSource(strings= {"5,2,3","4,2,2","0,3,-3"})
	public void testAddAgain(String param) {
		List<Integer>args=Arrays.asList(param.split(",")).stream().map(it->Integer.parseInt(it)).collect(Collectors.toList());
		assertEquals(args.get(0),arithmetic.add(args.get(1),args.get(2)));
		
	}
	
	@Test
	void testAdd() {
		assertEquals(11,arithmetic.add(7, 4));
		System.out.println("HI");
	}
	@Test
	void testSubtract() {
		assertEquals(15,arithmetic.subtract(19, 4));
		System.out.println("jkhkh");

	}
	@Test
	void testMult() {
		fail("Not yet implemented");
	}
	@Test
	void testDiv() {
		fail("Not yet implemented");
	}

}
