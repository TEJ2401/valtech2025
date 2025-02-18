package day2;

public class Generics<T> {
	private T x;
	private T y;
	public Generics() {
		
	}
	public Generics(T x, T y) {
		super();
		this.x = x;
		this.y = y;
	}
	public T getX() {
		return x;
	}
	public void setX(T x) {
		this.x = x;
	}
	public T getY() {
		return y;
	}
	public void setY(T y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "Generics [x=" + x + ", y=" + y + "]";
	}
	
}
