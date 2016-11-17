package com.bit2016.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2016.jblog.vo.CategoryVo;

@Repository
public class CategoryDao {
	
	@Autowired
	private SqlSession sqlSession;

	public boolean insert1(CategoryVo categoryVo) {
		return (sqlSession.insert("category.insert", categoryVo) == 1 );
	}
	
	public long insert(CategoryVo vo) {
		System.out.println("insertdao");
		sqlSession.insert("category.insert", vo);
		return vo.getUserNo();
	}

	public List<CategoryVo> getList() {
		System.out.println("getlistDao");
		return sqlSession.selectList("category.getList");
	}
	
	public void delete(CategoryVo vo) {
		sqlSession.delete("category.delete",vo);
	}

	public CategoryVo getInfo(Long userNo) {
		System.out.println("getInfoDao");
		return sqlSession.selectOne("category.getInfo", userNo);
	}

	public List<CategoryVo> categoryList(Long userNo) {
		return sqlSession.selectList("category.categoryList", userNo);
	}
	
}
