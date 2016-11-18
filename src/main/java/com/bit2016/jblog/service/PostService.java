package com.bit2016.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2016.jblog.repository.PostDao;
import com.bit2016.jblog.vo.PostVo;

@Service
public class PostService {

	@Autowired
	private PostDao postDao;
	
	public void write(PostVo postVo ) {
		postDao.write(postVo);
	}

	public List<PostVo> postList(Long userNo, Long categoryNo) {
		return postDao.postList(userNo, categoryNo);
	}

	public PostVo get(Long postNo) {
		return postDao.get(postNo);
	}
}
