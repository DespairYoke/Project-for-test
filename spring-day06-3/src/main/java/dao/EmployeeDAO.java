package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import entity.Employee;

@Repository("empDAO")
public class EmployeeDAO {
	
	@Autowired
	@Qualifier("jt")
	private JdbcTemplate jt;
	
	public void save(Employee e){
		String sql = "INSERT INTO t_emp "
				+ "VALUES(t_emp_seq.nextval,?,?,?)";
		//数组元素应该与?一一对应
		Object[] args = {e.getEname(),e.getSalary(),
				e.getAge()};
		jt.update(sql, args);
	}
	
	public List<Employee> findAll(){
		String sql = "SELECT * FROM t_emp";
		List<Employee> employees = 
				jt.query(sql, new EmpRowMapper());
		return employees;
	}
	
	public Employee findById(int id){
		String sql = "SELECT * FROM t_emp "
				+ "WHERE id = ?";
		Object[] args = {id};
		Employee e = null;
		try{
			e = jt.queryForObject(
					sql, args,new EmpRowMapper());
		}catch(EmptyResultDataAccessException e1){
			//找不到对应的记录，queryForObject方法
			//会抛出EmptyResultDataAccessException
			return null;
		}
		return e;
	}
	
	public void update(Employee e){
		String sql = "UPDATE t_emp SET "
				+ "ename=?,salary=?,age=? WHERE id=?";
		Object[] args  = {e.getEname(),
				e.getSalary(),e.getAge(),e.getId()};
		jt.update(sql, args);
	}
	
	public void delete(int id){
		String sql = "DELETE FROM t_emp WHERE id=?";
		Object[] args = {id};
		jt.update(sql,args);
	}
	
	
	
	
	
	
	
	
	
	/*
	 * 负责告诉JdbcTemplate如何将记录转换成一个对象。
	 */
	class EmpRowMapper 
		implements RowMapper<Employee>{
		/*
		 *  index:正在被处理的记录的下标。
		 */
		public Employee mapRow(ResultSet rs,
				int index) throws SQLException {
			Employee e = new Employee();
			e.setId(rs.getInt("id"));
			e.setEname(rs.getString("ename"));
			e.setSalary(rs.getDouble("salary"));
			e.setAge(rs.getInt("age"));
			return e;
		}
		
	}
	
	
	
	
	
	
	
}
