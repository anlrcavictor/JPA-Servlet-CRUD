package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

@Entity
public class Employee {
   
	
	@Id
	@TableGenerator(name="EMP_GEN")
	@GeneratedValue(generator = "EMP_GEN")
	private int id;
	private String name;
	private String surname;
	private int salary;
	
	@ManyToOne
	private Department department;
	
	
	public Employee() {
		super();
	}
	
	
	public Employee(String name, String surname, int salary, Department department) {
		super();
		this.name = name;
		this.surname = surname;
		this.salary = salary;
		this.department = department;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + ", salary=" + salary + ", department="
				+ department + "]";
	}
	
	
	
	
}
