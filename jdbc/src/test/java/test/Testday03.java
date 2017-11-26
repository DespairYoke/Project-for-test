package test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.DBUtil;

public class Testday03 {
	@Test 
	public void test2(){
		Connection conn;
		try {
			conn=DBUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="insert into depts ("
				+"depts_seq_nextval,?,?)";
	}
}
