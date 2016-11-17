package com.bit2016.jblog.service;

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
}
