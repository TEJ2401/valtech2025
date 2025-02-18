package day5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class EnhancedUtilsTest {

	@Test
	public void testMap() {
		Map<String,Integer>nums=Map.of("One",1,"Two",2,"Three",3);
		try {
			nums.put("Four", 4);
			fail("Immutable Collection Expected");
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	@Test
	public void testList() {
		List<Integer>nums=List.of(1,2,3,4);
		try {
			nums.add(5);
			fail("Immutable List Expected");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		List<Integer> nums1=new ArrayList<Integer>();
		nums1.addAll(nums);
		nums1.add(5);
		
		
	}
	
	@Test
	public void testMapsConventional() {
		Map<String,Integer>mp=new HashMap<String,Integer>();
		mp.put("One", 1);
		mp.put("Two",2);
		mp.put("Three", 3);
		
	}
	
	@Test
	void test() {
		
		List<Integer>nums=new ArrayList<Integer>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		List<Integer>ls=Arrays.asList(1,2,3);
		assertEquals(nums,ls);
		
		
//		fail("Not yet implemented");
	}

}
