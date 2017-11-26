package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {
	private static BasicDataSource ds;
	static{
		Properties p=new Properties();
		try {
			p.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String driver=p.getProperty("driver");
		String url = p.getProperty("url");
		String user = p.getProperty("user");
		String password = p.getProperty("password");
		String initSize=p.getProperty("init_size");
		String maxSize=p.getProperty("max_size");
		ds=new BasicDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(user);
		ds.setPassword(password);
		ds.setInitialSize(Integer.parseInt(initSize));
		ds.setMaxActive(Integer.parseInt(maxSize));
		
	}
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	public static void close(Connection conn){
		if(conn!=null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("πÈªπ¡¨Ω” ß∞‹",e);
			}
		}
	}
}
