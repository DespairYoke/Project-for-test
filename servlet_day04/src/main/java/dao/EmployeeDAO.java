package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Employee;
import util.DBUtil;

public class EmployeeDAO {
	public void save(Employee e){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "INSERT INTO t_emp "
					+ "VALUES(t_emp_seq.nextval,?,?,?)";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setString(1, e.getEname());
			ps.setDouble(2, e.getSalary());
			ps.setInt(3, e.getAge());
			ps.executeUpdate();
		} catch (SQLException e1) {
			//step1.记日志（保留现场）
			e1.printStackTrace();
			/*
			 * step2.看异常能否恢复，如果不能够
			 * 恢复(比如，数据库服务暂停等，一般我们
			 * 称之为系统异常)，要提示用户稍后重试。
			 * 如果能够恢复，则立即恢复。
			 */
			throw new RuntimeException(e1);
		}finally{
			DBUtil.close(conn);
		}
		
	}
	
	public List<Employee> findAll(){
		List<Employee> employees = 
			new ArrayList<Employee>();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM t_emp";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ResultSet rs = 
					ps.executeQuery();
			
			while(rs.next()){
				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setEname(rs.getString("ename"));
				e.setSalary(rs.getDouble("salary"));
				e.setAge(rs.getInt("age"));
				employees.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			DBUtil.close(conn);
		}
		return employees;
	}
}





