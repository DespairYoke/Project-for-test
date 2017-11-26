package test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;
import org.junit.runner.notification.RunListener;

import com.DBUtil;

import dao.EmpDao;

public class TestDay02 {
	@Test
	public void test1(){
		Connection conn = null;
		int empno=1;
		try {
			conn=DBUtil.getConnection();
			System.out.println(conn);
			Statement state=conn.createStatement();
			state.+
			String sql="delete from emps where empno="+empno;
			state.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("连接失败!",e);
		}finally{
			DBUtil.close(conn);
		}
	}
	@Test
	public void test2(){
		Connection conn = null;
		int empno=18;
		try {
			conn=DBUtil.getConnection();
			System.out.println(conn);
			/*创建ps对象，并发送sql*/
		PreparedStatement state = conn.prepareStatement(
				"select * from emps_biancong where empno=?");
		state.setInt(1, empno);
		ResultSet rs=state.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getString(2));
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("连接失败!",e);
		}finally{
			DBUtil.close(conn);
		}
	}
	@Test
	public void test3(){
		String ename="悟空";
		String job="保镖";
		int mgr=0;
		Date hiredate=new Date(System.currentTimeMillis());
		double sal=6000.0;
		double comm=2000.0;
		int deptno=2;
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="insert into emps_biancong values("
					+"emps_biancong_sql_nextval,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ename);
			ps.setString(2, job);
			ps.setInt(3, mgr);
			ps.setDate(4, hiredate);
			ps.setDouble(5, sal);
			ps.setDouble(6, comm);
			ps.setInt(7, deptno);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test4(){
		String username="zhangsan";
		String password="'a' or 'b'='b'";
		Connection conn;
		try {
			conn=DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from user "+
			"where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}
	@Test
	public void test5()
	{
		String payId="00001";
		String recId="00002";
		double mny=1000.0;
		Connection conn = null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from accounts where id=?";
			PreparedStatement ps2 = conn.prepareStatement(sql);
			ps.setString(1, payId);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				double payMoney=rs.getDouble("money");
				if(payMoney<mny)
				{
					System.out.println("不足");
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		
	}
	@Test
	public void test6(){
		EmpDao dao=new EmpDao();
		Emp e=dao.findById(2);
		System.out.println(e); 
	}
}
