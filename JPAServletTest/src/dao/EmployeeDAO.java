package dao;

import java.util.List;

import model.Department;
import model.Employee;

public interface EmployeeDAO {

	public void insertEmployee(Employee employee);
	
	public Employee findEmployee(int id);
	
	public List<Employee> findAllEmployees();
	
	public void removeEmployee(int id);
	
	public void updateEmployee(int id,Employee employee);
	
	
	
	
}
