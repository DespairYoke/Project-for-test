package dao;

import java.util.List;
import java.util.Map;

import entity.Emp2;
import entity.Employee;
/**
 * DAO接口
 *	
 */

public interface EmployeeDAO {
	public void save(Employee emp);
	public List<Employee> findAll();
	public Employee findById(int id);
	public void update(Employee e);
	public void delete(int id);
	public Map findById2(int id);
	public Emp2 findById3(int id);
}










