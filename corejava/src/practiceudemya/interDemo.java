package practiceudemya;

interface DatabaseConnections{
		void connect();
		void search();
		void delete();
		void update();
		void save();
		void getById();
}
class Postgre implements DatabaseConnections{

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void search() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getById() {
		// TODO Auto-generated method stub
		
	}
	
}

class MySQL implements DatabaseConnections{

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void search() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getById() {
		// TODO Auto-generated method stub
		
	}
	
}


class NoSQL implements DatabaseConnections{

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void search() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getById() {
		// TODO Auto-generated method stub
		
	}
	
}
interface City{
	String NAME="Jamnagar";
	String STATE="GUJARAT";
	
}

public class interDemo {
	public static void main(String[] args) {
		System.out.println(City.NAME);
		System.out.println(City.STATE);
	}
}
