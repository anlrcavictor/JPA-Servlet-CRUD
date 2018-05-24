package dao;

import java.util.List;

import model.Department;

public interface DepartmentDAO {

	public Department insertDepartment(String name);
	
	public Department findDepartment(int id);
	
	public List<Department> findAllDepartments();
	
	public void removeDepartment(int id);
	
	public void updateDepartment(int id,String name);
	
	public Department getDepartmentByName(String name);
	
	
	
	
	
	
}
