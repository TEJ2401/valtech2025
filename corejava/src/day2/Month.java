package day2;

public enum Month {

	JANUARY(31),FEBRUARY(28),MARCH(31),APRIL(30),MAY(31),JUNE(30),JULY(31),AUGUST(31),SEPTEMEBR(31),OCTOBER(31),NOVEMBER(31),DECEMBER(31);
	private int noOfDays;
	Month(int noofDays){
		this.noOfDays=noofDays;
		
	}
	
	@Override
	public String toString() {
		return "Month"+name()+"No Of Days="+noOfDays;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	
	
	
	public static void main(String[] args) {
		for(Month m:Month.values()) {
			System.out.println(m);
		}
	}
	
}
