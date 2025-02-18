package servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import dao.DeptDAO;
import dao.DeptDAOImp;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
public class ConfigListener implements ServletContextListener {
	private EmployeeDAO dao;
	private DeptDAO deptdao;
		@Override
		public void contextInitialized(ServletContextEvent sce) {
			// TODO Auto-generated method stub
			Properties pd=new Properties();
//			Map<String,String>mp=new HashMap<>();
			ServletContext context=sce.getServletContext();
			try(InputStream input= ConfigListener.class.getClassLoader().getResourceAsStream("jdbc.properties")) {
				if(input==null) {
					System.out.println("Sorry the file is empty");
					return;
				}
				pd.load(input);
				context.setAttribute("jdbc_url",pd.getProperty("jdbc.url"));
				context.setAttribute("jdbc_username",pd.getProperty("jdbc.username"));
				context.setAttribute("jdbc_password",pd.getProperty("jdbc.password"));
				context.setAttribute("jdbc_driver",pd.getProperty("jdbc.driver"));
				System.out.println(pd.getProperty("jdbc.driver"));
				dao=new EmployeeDAOImpl(context);
				deptdao=new DeptDAOImp(context);
				context.setAttribute("dept",deptdao);
				context.setAttribute("emp",dao);
				System.out.println();
			
			try {
				Class.forName((String)context.getAttribute("jdbc_driver"));
				
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		catch(Exception e) {
			e.printStackTrace();

		}
		}
		@Override
		public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
//		ServletContextListener.super.contextDestroyed(sce);
			System.out.println("Servlet Context Destroyed");
			
		}
}
