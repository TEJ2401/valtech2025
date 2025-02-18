package day1;

public class Point3D extends Point{
	private double z;
	
	public Point3D() {
		this.x=0;
		this.y=0;
		this.z=0;
	}
	
	public Point3D(double x,double y,double z) {
	
		this.x=x;
		this.y=y;
		this.z=z;
	}
	public double getZ()
	{
		return z;
	}
	public void setZ(int z) {
		this.z=z;
	}
	
	@Override
	public double distance() {
		return Math.sqrt(getX()*getX()+ getY()*getY()+ z*z);
	}
	public double distance(Point3D p) {
		return distance(p.getX(),p.getY(),p.getZ());
		
	}
	public double distance(double x,double y,double z)
	{
		double diffx=getX()-x;
		double diffy=getY()-y;
		double diffz=getZ()-z;
		
		return Math.sqrt(diffx*diffx + diffy*diffy + diffz*diffz);
	}
	public static void main(String args[]) {
		Point3D p3=new Point3D(24,1,3);
		System.out.println(p3.distance());
	}
}
