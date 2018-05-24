package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Department;
import utility.EntityManagerProvider;

public class DepartmentDAOImpl implements DepartmentDAO{

	private EntityManager entityManager;

	public DepartmentDAOImpl() {
		EntityManagerFactory entityManagerFactory = EntityManagerProvider.getEntityManagerFactory();
		this.entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public Department insertDepartment(String name) {

		Department department = new Department(name);

		entityManager.getTransaction().begin();
		entityManager.persist(department);
		entityManager.getTransaction().commit();

		return department;
	}

	@Override
	public Department findDepartment(int id) {

		return entityManager.find(Department.class, id);
	}

	@Override
	public List<Department> findAllDepartments() {
		Query query = entityManager.createQuery("Select e from Department e");
		return query.getResultList();
	}

	@Override
	public void removeDepartment(int id) {
		Department department = findDepartment(id);
		if (department != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(department);
			entityManager.getTransaction().commit();
		}
	}

	@Override
	public void updateDepartment(int id, String name) {

		Department department = findDepartment(id);

		entityManager.getTransaction().begin();
		department.setName(name);
		entityManager.getTransaction().commit();

	}

	public Department getDepartmentByName(String name) {
		
		TypedQuery<Department> query=entityManager.createQuery("Select e from Department e where e.name=:eName",Department.class).setParameter("eName",name);
		return query.getSingleResult();
			}
}


