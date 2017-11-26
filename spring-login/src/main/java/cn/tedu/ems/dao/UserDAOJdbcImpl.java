package cn.tedu.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import cn.tedu.ems.entity.User;


/**
 * 持久层实现类
 *
 */
@Repository("userDAO")
public class UserDAOJdbcImpl implements UserDAO{

	@Autowired
	@Qualifier("sst")
	private SqlSessionTemplate sst;
	
	public User findByUsername(String uname) {
		
		return (User) sst.selectOne("cn.tedu.ems.dao.UserDAO.findByUsername",uname);
	}

}




