package day3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

class UtilsTest {

	public class Point implements Comparable<Point>{

		
		private int x;
		private int y;
		public Point() {
			
		}
		public Point(int x,int y) {
			this.x=x;
			this.y=y;
		}
		public int getX() {
			return x;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(x, y);
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return x == other.x && y == other.y;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		private UtilsTest getEnclosingInstance() {
			return UtilsTest.this;
		}
		@Override
		public int compareTo(Point o) {
			if(this==o || this.equals(o)) {
				return 0;
			}
			int diffX=x-o.x;
			if(diffX==0) return y-o.y;
			return diffX;
		}
		
	}
	
	
	public void tryingList(Set<Point>points) {
		assertEquals(0,points.size());
		points.add(new Point(2,3));
		assertEquals(1,points.size());
		points.add(new Point(2,3));
		assertEquals(2,points.size());
		points.add(new Point(3,2));
		assertEquals(3,points.size());
		
	}
	public void tryingSet(List<Point>points) {
		assertEquals(0,points.size());
		points.add(new Point(2,3));
		assertEquals(1,points.size());
		points.add(new Point(2,3));
		assertEquals(2,points.size());
		points.add(new Point(3,2));
		assertEquals(3,points.size());
		
	}
	public void tryingMaps(Map<String,Integer>numbers) {
		assertEquals(0,numbers.size());
		numbers.put("One",1);
		assertEquals(1,numbers.size());
		assertEquals(1,numbers.get("One"));
		numbers.put("One",2);
		assertEquals(1,numbers.size());
		assertEquals(2,numbers.get("One"));
		numbers.put("one",1);
		assertEquals(2,numbers.size());
		assertEquals(2,numbers.size());
		
		
	}
	@Test
	public void testList() {
		tryingSet(new ArrayList<UtilsTest.Point>());
		tryingSet(new LinkedList<UtilsTest.Point>());
	}
	@Test
	public void tryingMaps() {
		tryingMaps(new HashMap<String,Integer>());
	};
//	@Test
//	public void testSet() {
//		tryingList(new HashSet<UtilsTest.Point>());x
////		tryingSet(new HashSet<UtilsTest.Point>());
//	}
//	
//	@Test
//	public void hashSet() {
//		tryingSet(new TreeSet<UtilsTest.Point>());
//	}

}
