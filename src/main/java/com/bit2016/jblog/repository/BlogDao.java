package com.bit2016.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2016.jblog.vo.BlogVo;

@Repository
public class BlogDao {

	@Autowired
	private SqlSession sqlSession;

	public boolean insert(BlogVo blogVo) {
		return (sqlSession.insert("blog.insert", blogVo) == 1 );
	}

	public BlogVo getInfo(String userId) {
		return sqlSession.selectOne("blog.getInfo", userId);
	}

	public void update(BlogVo blogVo) {
		sqlSession.update("blog.update", blogVo);
	}
}
