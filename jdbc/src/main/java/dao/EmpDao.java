package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.DBUtil;

import entity.Emp;

public class EmpDao implements Serializable{
	public void save(Emp e){
		
	}
	/**
	 * ����id�޸�Ա���������ֶ�
	 * */
	public void update(Emp e){
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="update emps set "
					+ "ename=?,"
					+ "job=?,"
					+ "mgr=?,"
					+ "hiredate=?,"
					+ "sal=?,"
					+ "comm=?,"
					+ "deptno=?"
					+ "where empno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
				
			ps.setString(1,e.getEname());
			ps.setString(2, e.getJob());
			ps.setInt(3, e.getMgr());
			ps.setDate(4, e.getHiredate());
			ps.setDouble(5, e.getSal());
			ps.setDouble(6, e.getComm());
			ps.setInt(7, e.getDeptno());
			ps.setInt(8, e.getEmpno());
			ps.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			throw new RuntimeException("�޸�Ա��ʧ��",e1);
		}finally{
			DBUtil.close(conn);
		}
	}
	public void delete(int id){
		
	}
	public Emp findById(int id)
	{
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from emps where empno=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				Emp e=new Emp();
				e.setEmpno(rs.getInt());
				rs.getString(1)
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	public List<Emp> findAll(){
		return null;
		
	}
	public List<Emp> findByPage(int page,int size){
		String sql="select * from ("
				+ "select e.*,rownum r from ("
				+ "select * from emps order by empno)"
				+ ") e"
				+"where r between ? and ?";
				
		return null;
	}
}
