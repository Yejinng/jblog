package com.bit2016.jblog.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2016.jblog.vo.PostVo;

@Repository
public class PostDao {

	@Autowired
	private SqlSession sqlSession;
	
	public int write(PostVo postVo) {
		System.out.println(postVo);
		return sqlSession.insert("post.write", postVo);
	}

	public List<PostVo> postList(Long userNo, Long categoryNo) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("userNo", userNo);
		map.put("categoryNo", categoryNo);
		return sqlSession.selectList("post.postList", map);
	}

	public PostVo get(Long postNo) {
		return sqlSession.selectOne("post.get", postNo);
	}
}
