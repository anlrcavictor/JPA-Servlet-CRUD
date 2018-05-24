package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DepartmentDAO;
import dao.DepartmentDAOImpl;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.Department;
import model.Employee;

@WebServlet("/employeeController")
public class EmployeeController extends HttpServlet {

	private static String INSERT="/employeeInsert.jsp";
	private static String LIST="/employee.jsp";
	private static String UPDATE="/employeeUpdate.jsp";
       
	private EmployeeDAO employeeService;
	private DepartmentDAO departmentService;
	private Department department;
	
	 public EmployeeController() {
	        super();
	        // TODO Auto-generated constructor stub
	         employeeService=new EmployeeDAOImpl();
	         departmentService=new DepartmentDAOImpl();
	         department=departmentService.insertDepartment("Software");
	         
	    }
	
	 
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

			String forward="";
			String action=req.getParameter("action");
			if(action==null){
			
			List<Employee> allEmployees = employeeService.findAllEmployees();
			req.setAttribute("allEmployees", allEmployees);
			forward=LIST;
			}
			else if(action.equals("insert")) {
				req.setAttribute("allDepartments", departmentService.findAllDepartments());
				forward=INSERT;
			}
			else if(action.equals("delete")) {
				int id = Integer.parseInt(req.getParameter("employeeId"));
				employeeService.removeEmployee(id);
				forward=LIST;
				
				req.setAttribute("allEmployees", employeeService.findAllEmployees());
				
			}
			else if(action.equals("update")) {
				forward=UPDATE;
				int id = Integer.parseInt(req.getParameter("employeeId"));
				Employee emp=employeeService.findEmployee(id);
				req.setAttribute("employee", emp);
				req.setAttribute("allDepartments", departmentService.findAllDepartments());
				
			}
			RequestDispatcher dispatcher = req.getRequestDispatcher(forward);
			dispatcher.forward(req, resp);
	}
	 
	 
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 	String employeeName = req.getParameter("name");
			String employeeSurname = req.getParameter("surname");
			int employeeSalary = Integer.parseInt(req.getParameter("salary"));
			String departmentName=req.getParameter("department");
			
			String employeeId = req.getParameter("id");
			
			
			if(employeeId==null) {
				Employee emp=new Employee(employeeName,employeeSurname, employeeSalary, departmentService.getDepartmentByName(departmentName));
				employeeService.insertEmployee(emp);
			}
			else {
				int id=Integer.parseInt(employeeId);
				Employee emp=new Employee(employeeName,employeeSurname, employeeSalary, departmentService.getDepartmentByName(departmentName));
				employeeService.updateEmployee(id, emp);
				
			}
			List<Employee> employeeList = employeeService.findAllEmployees();
			
			req.setAttribute("allEmployees", employeeList);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(LIST);
			dispatcher.forward(req, resp);
	}
	
	
}
