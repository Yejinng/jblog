package com.bit2016.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2016.jblog.exception.UserServiceException;
import com.bit2016.jblog.repository.BlogDao;
import com.bit2016.jblog.repository.CategoryDao;
import com.bit2016.jblog.repository.UserDao;
import com.bit2016.jblog.vo.BlogVo;
import com.bit2016.jblog.vo.CategoryVo;
import com.bit2016.jblog.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private BlogDao blogDao;
	@Autowired
	private CategoryDao categoryDao;
	
	public void join (UserVo vo ) throws UserServiceException {
		boolean result = false;
		// 가입
		result = userDao.insert(vo); 
		if( result == false) {
			throw new UserServiceException ("회원가입 실패");
		}
		Long userNo = vo.getUserNo();
		// 블로그
		BlogVo blogVo = new BlogVo();
		blogVo.setUserNo(userNo);
		blogVo.setBlogTitle(vo.getName() + "의 블로그");
		blogVo.setBlogLogo("default");
		
		result = blogDao.insert(blogVo);
		
		if( result == false) {
			throw new UserServiceException ("블로그 생성 실패");
		}
		//카테고리
		CategoryVo categoryVo = new CategoryVo();
		categoryVo.setUserNo(userNo);
		categoryVo.setCategoryName("기본카테고리");
		categoryVo.setCategoryDescription("뭐.....");
		
		result = categoryDao.insert(categoryVo);
		
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
