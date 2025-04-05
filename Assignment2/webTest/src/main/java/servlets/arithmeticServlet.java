package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class arithmeticServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		String company= config.getInitParameter("company");
		System.out.println("Init....."+company+"Tej");
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String content="""
				<!DOCTYPE html>
				+ "<html>\n"
				+ "<head>\n"
				+ "<meta charset=\"UTF-8\">\n"
				+ "<title>Insert title here</title>\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "\n"
				+ "\n"
				+ "<form action=\"arithmetic\" method=\"post\">\n"
				+ "\n"
				+ "A=<input type=\"text\" name=\"a\"/><br/>\n"
				+ "B=<input type=\"text\" name=\"b\"/><br/>\n"
				+ "<input type=\"submit\" name=\"operation1\" value=\"Add\"/>\n"
				+ "<input type=\"submit\" name=\"operation\" value=\"Sub\"/>\n"
				+ "<input type=\"submit\" name=\"operation\" value=\"Mul\"/>\n"
				+ "<input type=\"submit\" name=\"operation\" value=\"Div\"/>\n"
				+ "</form>\n"
				+ "</body>\n"
				+ "</html> """;
		req.getRequestDispatcher("arithmetic.jsp").forward(req, resp);
//		resp.getWriter().print(content);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int a=Integer.parseInt(req.getParameter("a"));
		int b=Integer.parseInt(req.getParameter("b"));
		System.out.println("Arithmetic Operation");
		String operation=req.getParameter("operation");
		int result=0;
		System.out.println(a);
		if("Add".equals(operation)) {
			result=a+b;
		}
		else if("Sub".equals(operation)) {
			result=a-b;
		}
		else if("Mul".equals(operation)) {
			result=a*b;
		}
		else {
			result=a/b;
		}
//		MessageFormat mf=new MessageFormat("A={}{} B={}={}");
//		System.out.println(MessageFormat.format("A={0}{1} B={2}={3}","A",a,operation,b,result));
//		String content="""
//				<!DOCTYPE html>
//				+ "<html>\n"
//				+ "<head>\n"
//				+ "<meta charset=\"UTF-8\">\n"
//				+ "<title>Insert title here</title>\n"
//				+ "</head>\n"
//				+ "<body>\n"
//				A={0}<br/>
//				B={1}<br/>
//				Operation={2}<br/>
//				Result={3}<br/>
//				+ "\n"
//				+ "\n"
//				+ "<form action=\"arithmetic\" method=\"post\">\n"
//				+ "\n"
//				+ "A=<input type=\"text\" name=\"a\"/><br/>\n"
//				+ "B=<input type=\"text\" name=\"b\"/><br/>\n"
//				+ "<input type=\"submit\" name=\"operation1\" value=\"Add\"/>\n"
//				+ "<input type=\"submit\" name=\"operation\" value=\"Sub\"/>\n"
//				+ "<input type=\"submit\" name=\"operation\" value=\"Mul\"/>\n"
//				+ "<input type=\"submit\" name=\"operation\" value=\"Div\"/>\n"
//				+ "</form>\n"
//				+ "</body>\n"
//				+ "</html> """;
//		
//		PrintWriter out=resp.getWriter();
//		out.print(MessageFormat.format(content,a,b,operation,result));
		req.setAttribute("result", result);
		req.getRequestDispatcher("arithmetic.jsp").forward(req, resp);
	}
}
