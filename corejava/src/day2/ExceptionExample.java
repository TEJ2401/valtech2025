package day2;

public class ExceptionExample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Authenticator a=new Authenticator();
		try {
			long code=a.authenticate("scott","tiger");
			System.out.println(code);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally {
			System.out.println("Finally");
		}
	}

}
