package servlets;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import dao.DeptDAO;
import dao.Employee;
import dao.Employee.Gender;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import services.EmployeeService;


@WebServlet(urlPatterns="/employees")
public class EmployeesServlet extends HttpServlet{
	
	private EmployeeDAO dao;
	private EmployeeService empservice;
	
	
	public void init(ServletConfig config) throws ServletException{
//		ServletContext sce =config.getServletContext();
		System.out.println("hello init");
//		deptdao=(DeptDAO)config.getServletContext().getAttribute("dept");
		ServletContext sce=config.getServletContext();
		dao=new EmployeeDAOImpl((String)sce.getAttribute("jdbc_username"),(String)sce.getAttribute("jdbc_password"),(String)sce.getAttribute("jdbc_url"));
		empservice=new EmployeeService();
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation=req.getParameter("operation");
		HttpSession session=req.getSession();
		String options=req.getParameter("options");
		System.out.println(req.getParameter("buttonValue"));
		System.out.println("rew"+req.getParameter("reset"));
			if("RESET".equals(req.getParameter("reset"))) {
				req.setAttribute("emps", dao.getAll());
				req.getRequestDispatcher("/employees.jsp").forward(req, resp);
				return;
			}
			if("employees".equals(req.getParameter("buttonValue")) || "depts".equals(req.getParameter("buttonValue"))) {
				
				System.out.println("Button Value"+req.getParameter("buttonValue"));
				List<Employee>employeesList=null;
				if("employees".equals(req.getParameter("buttonValue")))
				{
					employeesList=dao.getAll() ;
				}
				else if("depts".equals(req.getParameter("buttonValue"))) {
					Dept d=(Dept)session.getAttribute("current");
					employeesList=dao.getEmployeeByDepartment(d.getId());
				}
				if(req.getParameter("searchbyid")!=null && !req.getParameter("searchbyid").isEmpty()) {
					employeesList=empservice.searchById(employeesList,operation,Integer.parseInt(req.getParameter("searchbyid")));
				}
				if(req.getParameter("searchbyname")!=null && !req.getParameter("searchbyname").isEmpty()) {
					employeesList=empservice.searchByName(employeesList,operation,req.getParameter("searchbyname"));
				}
				if(req.getParameter("Age")!=null && !req.getParameter("Age").isEmpty()) {
					System.out.println("InSide");
					employeesList=empservice.searchByAge(employeesList,(String)(req.getParameter("age")),Integer.parseInt(req.getParameter("Age")));
				}
				if(req.getParameter("Salary")!=null && !req.getParameter("Salary").isEmpty()) {
					employeesList=empservice.searchBySalary(employeesList,(String)(req.getParameter("salary")),Integer.parseInt(req.getParameter("Salary")));
				}
				if(req.getParameter("Gender")!=null && !req.getParameter("Gender").isEmpty()) {
					employeesList=empservice.searchByGender(employeesList,(String)(req.getParameter("gender")),req.getParameter("Gender"));
				}
				if(req.getParameter("Experience")!=null && !req.getParameter("Experience").isEmpty()) {
					employeesList=empservice.searchByExperience(employeesList,(String)(req.getParameter("expr")),Integer.parseInt(req.getParameter("Experience")));
				}
				if(req.getParameter("Level")!=null && !req.getParameter("Level").isEmpty()) {
					employeesList=empservice.searchByLevel(employeesList,(String)(req.getParameter("levelr")),Integer.parseInt(req.getParameter("Level")));
				}
				req.setAttribute("emps",employeesList);
				
				if("employees".equals(req.getParameter("buttonValue"))) {
					req.getRequestDispatcher("employees.jsp").forward(req, resp);
					return;
				}
				
				req.setAttribute("flag",true);
				req.getRequestDispatcher("/depts").forward(req, resp);
				return;
							
			}

	
			
			if("SortById".equals(operation)) {			
				Boolean a=(Boolean)session.getAttribute("SortById");
				req.setAttribute("emps",empservice.sortById(a,dao.getAll()));
				session.setAttribute("SortById",session.getAttribute("SortById")==null?true:!(Boolean)session.getAttribute("SortById"));
				req.getRequestDispatcher("employees.jsp").forward(req, resp);
				return;
				
			}

		if("SortByName".equals(operation)) {			
			Boolean a=(Boolean)session.getAttribute("SortByName");
			req.setAttribute("emps",empservice.sortByName(a,dao.getAll()));
			session.setAttribute("SortByName",session.getAttribute("SortByName")==null?true:!(Boolean)session.getAttribute("SortByName"));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
			
		}
		else if("SortByAge".equals(operation)) {
			
			Boolean a=(Boolean)session.getAttribute("SortByAge");
			req.setAttribute("emps",empservice.sortByAge(a,dao.getAll()));
			session.setAttribute("SortByAge",session.getAttribute("SortByAge")==null?true:!(Boolean)session.getAttribute("SortByAge"));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		if("SortByNameDepts".equals(operation)) {

			Dept abs=(Dept)session.getAttribute("current");
			List<Employee>sortedByName=dao.getEmployeeByDepartment(abs.getId()).stream().sorted((o1,o2)->o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
			req.setAttribute("flag",true);
			req.setAttribute("emps",sortedByName);
			req.getRequestDispatcher("/depts").forward(req, resp);	
		}
		else if("SortBySalary".equals(operation)) {
			
			Boolean a=(Boolean)session.getAttribute("SortBySalary");
			req.setAttribute("emps",empservice.sortBySalary(a,dao.getAll()));
			session.setAttribute("SortBySalary",session.getAttribute("SortBySalary")==null?true:!(Boolean)session.getAttribute("SortBySalary"));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
			
		}
		else if("SortByExperience".equals(operation)) {
			
			Boolean a=(Boolean)session.getAttribute("SortByExperience");
			req.setAttribute("emps",empservice.sortByExperience(a,dao.getAll()));
			session.setAttribute("SortByExperience",session.getAttribute("SortByExperience")==null?true:!(Boolean)session.getAttribute("SortByExperience"));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
			
		}
		else if("SortByLevel".equals(operation)) {
			
			Boolean a=(Boolean)session.getAttribute("SortByLevel");
			req.setAttribute("emps",empservice.sortByLevel(a,dao.getAll()));
			session.setAttribute("SortByLevel",session.getAttribute("SortByLevel")==null?true:!(Boolean)session.getAttribute("SortByLevel"));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
			
		}
		else if("newEmp".equals(operation)) {
			req.setAttribute("mode","Save");
			req.setAttribute("readOnly", "");
			req.getRequestDispatcher("EditEmployees.jsp").forward(req,resp);
			return;
		}
		else if("delete".equals(operation)) {
			int id=Integer.parseInt(req.getParameter("id"));
			dao.delete(id);
			req.setAttribute("emps",dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		else if("update".equals(operation)) {
			req.setAttribute("readOnly","readOnly");
			int id=Integer.parseInt(req.getParameter("id"));
			Employee e=dao.get(id);
			req.setAttribute("emps", e);
			req.setAttribute("mode","update");
			System.out.println(req.getAttribute("mode"));
			req.getRequestDispatcher("EditEmployees.jsp").forward(req, resp);
			return;
		}
		else {
			req.setAttribute("emps" ,dao.getAll());
			System.out.println(dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req,resp);
			
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String operation=req.getParameter("operation");
		System.out.println(operation);
		Employee emp= Employee.builder().setId(Integer.parseInt(req.getParameter("id"))).setAge(Integer.parseInt(req.getParameter("age"))).setExp(Integer.parseInt(req.getParameter("experience"))
				).setGender(Gender.valueOf(req.getParameter("gender").toUpperCase())).setLevel(Integer.parseInt(req.getParameter("level"))).setName(req.getParameter("name")).setSalary(Integer.parseInt(req.getParameter("salary"))).setDeptNo(Integer.parseInt(req.getParameter("deptno"))).build();
	
		if("Cancel".equals(operation)) {
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req,resp);
			return;
		}
//		if(operation.equals(emp))
		if("Save".equals(operation)) {
			System.out.println(emp);
			dao.save(emp);
			req.setAttribute("emps", dao.getAll());
			System.out.println(req.getAttribute("emps"));
			req.getRequestDispatcher("employees.jsp").forward(req,resp);
			return;
		}
		if("update".equals(operation)) {
			dao.update(emp);
			System.out.println(dao.getAll());
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req,resp);
			return;
		}
		else {
			String abc=req.getParameter("options");
			System.out.println(abc);
//			req.setAttribute(abc, abc);
		}
	}
}
