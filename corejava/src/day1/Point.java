package day1;

public class Point {
	 
		//*
		public static double ORIGIN=0;
		public static final double ZERO=0;
		public double x;
		public double y;
		public Point() {
			
			this.x=0;
			this.y=0;
		}
		public Point(double x,double y)
		{
			this.x=x;
			this.y=y;
		}
		public void Point(double t) {
			System.out.println(t*t);
		}
		
		public double distance(double x1,double x2)
		{
			double diffx=x1-x;
			double diffy=x2-y;
			return Math.sqrt(diffx*diffx + diffy*diffy);
		}

		public double getX() {
			return x;
		}
		
		
		public void setX(double x) {
			this.x=x;
		}
		public double getY() {
			return y;
		}
		public void setY(double y) {
			this.y=y;
		}
		public double distance(Point p) {
			return distance(0,0);
		}
		
		public double distance()
		{
			return Math.sqrt(x*x+y*y);
		}
		
		public static void main(String args[]) {
			Point p=new Point(2,4);
			p.Point(25);
			
		}
		
		@Override
		public String toString()
		{
			return "Point X="+x+"Y= "+y;
		}
	
}
