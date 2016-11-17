package com.bit2016.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2016.jblog.repository.CategoryDao;
import com.bit2016.jblog.vo.CategoryVo;

@Service
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	public List<CategoryVo> getList() {
		return categoryDao.getList();
	}

	public void insert (CategoryVo vo) {
		categoryDao.insert(vo);
	}
	
	public void delete (CategoryVo vo) {
		categoryDao.delete(vo);
	}
	
	public boolean createCategory(CategoryVo vo) {
		Long no = categoryDao.insert(vo);
		System.out.println("createcategory service:" + no);
		return (no==1);
	}

	public CategoryVo getInfo(Long userNo) {
		return categoryDao.getInfo(userNo);
	}

	public List<CategoryVo> categoryList(Long userNo) {
		return categoryDao.categoryList(userNo);
	}


}
