package dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import annotations.MyBatisRepository;
import entity.Emp2;
import entity.Employee;
/**
 * Mapper映射器
 *
 */
@Repository("empDAO")
public interface EmployeeDAO {
	public void save(Employee emp);
	public List<Employee> findAll();
	public Employee findById(int id);
	public void update(Employee e);
	public void delete(int id);
	public Map findById2(int id);
	public Emp2 findById3(int id);
}










