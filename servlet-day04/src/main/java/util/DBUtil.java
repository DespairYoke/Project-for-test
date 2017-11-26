package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {
	private static BasicDataSource ds;
	static {
		Properties p = new Properties();
		try {
			p.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			// ��ȡ����
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String pwd = p.getProperty("pwd");
			String initSize = p.getProperty("init_size");
			String maxSize = p.getProperty("max_size");
			// �������ӳ�
			ds = new BasicDataSource();
			// �����ӳ����ò���
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(user);
			ds.setPassword(pwd);
			ds.setInitialSize(Integer.parseInt(initSize));
			ds.setMaxActive(Integer.parseInt(maxSize));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("����db.propertiesʧ��", e);
		}
	}

	/**
	 * �����ӳش���������,��ʵ���������ӳ��ṩ.
	 *
	 */
	public static Connection getConnection() throws SQLException {

		return ds.getConnection();

	}
	/**
	 * 
	 * ���ӳ��ṩ��ʵ����,��close�����ڲ��߼���,
	 * �����ӹ黹�����ӳ�,������������Ӷ����е�����,
	 * ���ҽ����ӱ��Ϊ����״̬
	 */
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
				throw new RuntimeException("�黹����ʧ��", e);
			}

		}
	}
	public static void rollback(Connection conn){
		if(conn!=null){
			try {
				conn.rollback();
			} catch (SQLException e) {
				
				e.printStackTrace();
				throw new RuntimeException("�ع�����ʧ��",e);
			}
		}
	}
}
