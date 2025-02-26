package day4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.io.*;
class IOTest {

	@Test
	public void testBufferedReader() {
		try(BufferedReader br=new BufferedReader(new FileReader(new File("data.txt")))){
			System.out.println("In the bufferedReader");
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testReadableTryWithResource() throws FileNotFoundException, IOException {
		try(InputStream is=new FileInputStream(new File("data.txt"))){
			
			byte[] buff=new byte[4];
			int bytesRead=is.read(buff);
			assertEquals(4,bytesRead);
//			assertEquals(4,is.read(buff));
			System.out.println(new String(buff));
			assertEquals(4,is.read(buff));
			System.out.println(new String(buff));
			assertEquals(3,is.read(buff));
			System.out.println(new String(buff));
			assertEquals(-1,is.read(buff));
			System.out.println(new String(buff));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testReaders() {
		try(Reader reader=new FileReader(new File("data.txt"))){
			try(Writer writer=new FileWriter(new File("dataOut.txt"))){
				char[]buff=new char[4];
				int i=-1;
				while((i=reader.read(buff))!=-1) {
					writer.write(buff,0,i);
				}
				writer.flush();
			}

			
		}
		catch(Exception e) {
			
		}
	}
	
	@Test
	public void testChainingStreams() {
		try(InputStream is=new BufferedInputStream(new FileInputStream(new File("data.txt")))){
			try(OutputStream os=new FileOutputStream("dataCopy.txt")){
				byte[] buff=new byte[4];
				int i=0;
				while((i=is.read(buff))!=-1) {
					System.out.println(new String(buff,0,i));
					os.write(buff,0,i);
				}
				os.flush();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Test
	public void testwritable() throws FileNotFoundException, IOException {
		try(InputStream is=new FileInputStream(new File("data.txt"))){
			try(OutputStream os=new FileOutputStream("dataCopy.txt")){
				byte[] buff=new byte[4];
				int i=0;
				while((i=is.read(buff))!=-1) {
					System.out.println(new String(buff,0,i));
					os.write(buff,0,i);
				}
				os.flush();
			}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void testwrite() throws FileNotFoundException, IOException {
		try(InputStream is=new FileInputStream(new File("data.txt"))){
			
			byte[] buff=new byte[4];
			int bytesRead=is.read(buff);
			assertEquals(4,bytesRead);
			assertEquals(4,is.read(buff));
			System.out.println(new String(buff));
			assertEquals(4,is.read(buff));
			System.out.println(new String(buff));
			assertEquals(3,is.read(buff));
			System.out.println(new String(buff));
			assertEquals(-1,is.read(buff));
			System.out.println(new String(buff));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testReadable() throws FileNotFoundException, IOException {
		try(InputStream is=new FileInputStream(new File("data.txt"))){
			byte[]buff=new byte[4];
			int i=0;
			while((i=is.read(buff))!=-1) {
				is.read
				System.out.println(new String(buff,0,i));
			}
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Test
//	public void test() {
//		InputStream is=null;
//		try {
//	 is=new FileInputStream(new File("data.txt"));
//			int h='H';
//			
//			assertEquals(h,((byte)is.read()));
//			assertEquals('e',((byte)is.read()));
//			assertEquals('e',((byte)is.read()));
//			is.close();
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			try {
//				is.close();
//			}
//
//			catch(IOException e) {
//				e.printStackTrace();
//			}
//		}
//
//	}
}
