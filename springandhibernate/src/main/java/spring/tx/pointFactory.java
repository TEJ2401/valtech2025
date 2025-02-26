package spring.tx;

import spring.ioc.Point;

public class pointFactory {
	
	public static Point createPoint() {
		return new Point();
	}
}
