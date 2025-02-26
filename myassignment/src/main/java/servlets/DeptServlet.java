package servlets;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import dao.DeptDAO;
import dao.DeptDAOImp;
import dao.Employee;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import services.EmployeeService;
import services.SessionService;

@WebServlet(urlPatterns="/depts")
public class DeptServlet extends HttpServlet {
	private DeptDAO deptdao;	
	private EmployeeDAOImpl empdao;
	private DeptDAOImp dept;
	private EmployeeService empservice;
	private SessionService sesservice;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
//		ServletContext sce=config.getServletContext();
//		deptdao=(DepDAOImpl)sce.getAttribute("Department");
		deptdao=(DeptDAO)config.getServletContext().getAttribute("dept");
		empdao=(EmployeeDAOImpl)config.getServletContext().getAttribute("emp");
		empservice=new EmployeeService();
		sesservice=new SessionService();
//		empdao=(EmployeeDAOImpl)sce.getAttribute("Employee");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stubs
		String operation=req.getParameter("operation");
		HttpSession session=req.getSession();
		Dept current=(Dept) session.getAttribute("current");
		System.out.println("Printing The Current Object"+current);
		
		if("Reset".equals(operation)) {
			Dept d=(Dept)session.getAttribute("current");
			List<Employee>ls=empdao.getEmployeeByDepartment(d.getId());
			req.setAttribute("emps",ls);
			req.setAttribute("dept",d);
			req.getRequestDispatcher("depts.jsp").forward(req, resp);
			return;
			
		}
		else if(current==null) {
			
			current=deptdao.first();
			System.out.println(current);
		}
		else {
			if("First".equals(operation)) {
				current=deptdao.get(1);
			}
			else if("Last".equals(operation)) {
				current= deptdao.last();
			}
			else if("Previous".equals(operation)) {
				current=deptdao.previous(current.getId());
			}
			else {
				System.out.println("In the Next Method");
				System.out.println("Next");
				current=deptdao.next(current.getId());
			}
		}

		sesservice.clearSession(session);
		session.setAttribute("current", current);
		req.setAttribute("emps", empdao.getEmployeeByDepartment(current.getId()));
		req.setAttribute("dept", current);

		Cookie [] cookies=req.getCookies();
		for(int i=0;i<cookies.length;i++) {
			System.out.println(cookies[i].getName()+" "+cookies[i].getValue());
		}
		
		resp.addCookie(new Cookie("operation",operation));
		req.getRequestDispatcher("depts.jsp").forward(req,resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setAttribute("dept",deptdao.first());
		HttpSession session=req.getSession();
		System.out.println("IN THE DEPT SERVLET"+session.getAttribute("current"));
		
		if((Boolean)req.getAttribute("flag")!=null && (Boolean)req.getAttribute("flag")==true) {
			req.setAttribute("dept", session.getAttribute("current"));
			req.getRequestDispatcher("depts.jsp").forward(req, resp);
			return;
		}
		
		if("SortByName".equals(req.getParameter("operation"))) {
			Boolean a=(Boolean)session.getAttribute("SortByNameDepts");
			Dept dep=(Dept)session.getAttribute("current");
			List<Employee>deptemployees=empdao.getEmployeeByDepartment(dep.getId());
			List<Employee>sortedList=empservice.sortByName(a,deptemployees);
			req.setAttribute("emps", sortedList);
			req.setAttribute("dept", dep);
		    session.setAttribute("SortByNameDepts",session.getAttribute("SortByNameDepts")==null?true:!(Boolean)session.getAttribute("SortByNameDepts"));
		req.getRequestDispatcher("depts.jsp").forward(req, resp);
		return;
		}
else if("SortByAge".equals(req.getParameter("operation"))) {
			
			Boolean a=(Boolean)session.getAttribute("SortByAgeDepts");
			Dept dep=(Dept)session.getAttribute("current");
			List<Employee>deptemployees=empdao.getEmployeeByDepartment(dep.getId());
			List<Employee>sortedList=empservice.sortByAge(a,deptemployees);
			req.setAttribute("emps", sortedList);
			req.setAttribute("dept", dep);
		    session.setAttribute("SortByAgeDepts",session.getAttribute("SortByAgeDepts")==null?true:!(Boolean)session.getAttribute("SortByAgeDepts"));
		req.getRequestDispatcher("depts.jsp").forward(req, resp);
			return;
		}

		else if("SortBySalary".equals(req.getParameter("operation"))) {
			
			Boolean a=(Boolean)session.getAttribute("SortBySalaryDepts");
			Dept dep=(Dept)session.getAttribute("current");
			List<Employee>deptemployees=empdao.getEmployeeByDepartment(dep.getId());
			List<Employee>sortedList=empservice.sortBySalary(a,deptemployees);
			req.setAttribute("emps", sortedList);
			req.setAttribute("dept", dep);
			session.setAttribute("SortBySalaryDepts",session.getAttribute("SortBySalaryDepts")==null?true:!(Boolean)session.getAttribute("SortBySalaryDepts"));
			req.getRequestDispatcher("depts.jsp").forward(req, resp);
			return;
			
		}
		else if("SortByExperience".equals(req.getParameter("operation"))) {
			
			Boolean a=(Boolean)session.getAttribute("SortByExperienceDepts");
			Dept dep=(Dept)session.getAttribute("current");
			List<Employee>deptemployees=empdao.getEmployeeByDepartment(dep.getId());
			List<Employee>sortedList=empservice.sortByExperience(a,deptemployees);
			req.setAttribute("emps", sortedList);
			req.setAttribute("dept", dep);
			session.setAttribute("SortByExperienceDepts",session.getAttribute("SortByExperienceDepts")==null?true:!(Boolean)session.getAttribute("SortByExperienceDepts"));

			req.getRequestDispatcher("depts.jsp").forward(req, resp);
			return;
			
		}
		else if("SortByLevel".equals(req.getParameter("operation"))) {
			
			Boolean a=(Boolean)session.getAttribute("SortByLevelDepts");
			Dept dep=(Dept)session.getAttribute("current");
			List<Employee>deptemployees=empdao.getEmployeeByDepartment(dep.getId());
			List<Employee>sortedList=empservice.sortByLevel(a,deptemployees);
			req.setAttribute("emps", sortedList);
			req.setAttribute("dept", dep);
			session.setAttribute("SortByLevelDepts",session.getAttribute("SortByLevelDepts")==null?true:!(Boolean)session.getAttribute("SortByLevelDepts"));
			req.getRequestDispatcher("depts.jsp").forward(req, resp);
			return;
			
		}
		
		else
		{
			sesservice.clearSession(session);
			session.setAttribute("SortByNameDepts",null);
		req.setAttribute("emps",empdao.getEmployeeByDepartment(deptdao.first().getId()));
		session.setAttribute("current",deptdao.first());
		System.out.println("Session"+session.getAttribute("current"));
		}
//		session.setAttribute("current",deptdao.first());
		System.out.println(empdao.getEmployeeByDepartment(deptdao.first().getId()));

		req.getRequestDispatcher("/depts.jsp").forward(req, resp);

	}
}
