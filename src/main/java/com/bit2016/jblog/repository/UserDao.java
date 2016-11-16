package com.bit2016.jblog.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2016.jblog.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
		
	// 로그인 인증
	public UserVo get(String id, String password) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("password", password);
		System.out.println("dao id:" +id);
		return sqlSession.selectOne("user.getByIdAndPassword", map);
	}
	
	//이메일 중복확인
	public UserVo get(String id) {
		return sqlSession.selectOne("user.getById",id);
	}
	
	// 사용자 가져오기
	public UserVo get(Long no) {
		return sqlSession.selectOne("user.getByNo",no);
	}
	
	public void insert(UserVo vo) {
		sqlSession.insert("user.insert", vo);
	}
	
	public void update(UserVo vo)  {
		sqlSession.update("user.update",vo);
	}
}
