package com.bit2016.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2016.jblog.repository.UserDao;
import com.bit2016.jblog.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public void join (UserVo vo ) {
		userDao.insert(vo);
	}
	
	public UserVo login(String id, String password) {
		UserVo userVo = null;
		System.out.println("service id:" + id);
		userVo = userDao.get(id, password);
		return userVo;
	}
	
	public UserVo getUser( Long no ) {
		return userDao.get(no);
	}
	
	public void updateUser( UserVo vo ) {
		userDao.update(vo);
	}
	
	public boolean idExists(String id){
		return userDao.get(id) != null;
	}
}
