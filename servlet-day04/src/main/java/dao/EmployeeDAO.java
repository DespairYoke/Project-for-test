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
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql = "INSERT INTO t_emp_syz VALUES(t_emp_seq_syz.nextval,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e.getEname());
			ps.setDouble(2, e.getSalary());
			ps.setInt(3, e.getAge());
			ps.executeUpdate();
		} catch (SQLException e1) {
			//step1.����־(�����ֳ�)
			e1.printStackTrace();
			/*
			 * step2.���쳣�ܷ�ָ�,������ָܻ�(����,���ݿ����
			 * ��ͣ��,���ǳ�֮Ϊϵͳ�쳣),Ҫ��ʾ�û��Ժ�����
			 * ����ָܻ�,�������ָ�
			 * 
			 * */
			throw new RuntimeException(e1);
		}finally{
			DBUtil.close(conn);
		}
		
	}
	public List<Employee> findAll(){
		List<Employee> list = new ArrayList<Employee>();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from t_emp_syz ORDER BY id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setEname(rs.getString("ename"));
				e.setSalary(rs.getDouble("salary"));
				e.setAge(rs.getInt("age"));
				System.out.println(e.toString());
				list.add(e);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
			
		}
		return list;
	
		
		
		
	
		
		
	}
	public void Del(int id){
		Connection conn =null;
		try {
			conn =DBUtil.getConnection();
			String sql = "delete from t_emp_syz where id =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			DBUtil.close(conn);
		}
		
	}
	
	public Employee findById(int id){
		Employee e =null;
		Connection conn = null;
		try {
			 conn = DBUtil.getConnection();
			 String sql = "SELECT * FROM t_emp_syz WHERE id =?";
			 PreparedStatement ps = conn.prepareStatement(sql);
			 ps.setInt(1, id);
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()){
				 e =new Employee();
				 e.setId(id);
				 e.setEname(rs.getString("ename"));
				 e.setSalary(rs.getDouble("salary"));
				 e.setAge(rs.getInt("age"));
			 }
		} catch (SQLException e1) {
		
			
			e1.printStackTrace();
			throw new RuntimeException(e1);
		}finally{
			DBUtil.close(conn);
		}
		
		return e;
	}
	public void update(Employee e){
		Connection conn =null;
		try {
			 conn = DBUtil.getConnection();
			 String sql = "update t_emp_syz set ename =?,salary=?,age=? WHERE id =?";
			 
			 PreparedStatement ps = conn.prepareStatement(sql);
			 ps.setString(1, e.getEname());
			 ps.setDouble(2,e.getSalary());
			 ps.setInt(3, e.getAge());
			 ps.setInt(4, e.getId());
			 ps.executeUpdate();		
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		
		
		
		
	}
	
}
