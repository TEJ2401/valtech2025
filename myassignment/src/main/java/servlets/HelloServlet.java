package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	//dont write your own constructor
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		String company= config.getInitParameter("company");
		System.out.println("Init....."+company);
	}
	
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String name=request.getParameter("username");
		PrintWriter out=response.getWriter();
		out.print("Hello Servlets"+name+" !");
		
		
	}
	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Destory.......");
	}
}
