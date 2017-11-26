package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBTool {
	private static String user;
	private static String password;
	private static String url;
	static{
		Properties p=new Properties();
		try {
			p.load(DBTool.class.getClassLoader().getResourceAsStream("properties"));
			String driver=p.getProperty("driver");
			url=p.getProperty("url");
			user=p.getProperty("user");
			password=p.getProperty("password");
			try {
				Class.forName("driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("«˝∂Øº”‘ÿ ß∞‹!",e);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Connection getConnection() throws SQLException{
		
		return DriverManager.getConnection(url, user, password);
		
	}
	public static void close(Connection conn) {
		// TODO Auto-generated method stub
		try {
			if(conn!=null){
			conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
