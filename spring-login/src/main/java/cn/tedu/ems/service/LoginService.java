package cn.tedu.ems.service;

import cn.tedu.ems.entity.User;

public interface LoginService {
	public User checkLogin(String uname,String password);
}
