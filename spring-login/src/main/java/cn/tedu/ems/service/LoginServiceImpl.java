package cn.tedu.ems.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.ems.dao.UserDAO;
import cn.tedu.ems.entity.User;

@Service("loginService")
public class LoginServiceImpl implements LoginService{
	@Resource(name="userDAO")
	private UserDAO dao;
	public User checkLogin(String uname, String pwd) {
		User user=dao.findByUsername(uname);
		if(user==null)
		{
			throw new AppException("用户名不存在");
		}
		if(!user.getPassword().equals(pwd))
		{
			throw new AppException("密码错误");
		}
		return user;
	}

}
