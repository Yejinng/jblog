package com.bit2016.jblog.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2016.jblog.service.BlogService;
import com.bit2016.jblog.service.CategoryService;
import com.bit2016.jblog.vo.CategoryVo;

@Controller("blogAPIController")
@RequestMapping("/blog/api")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	@Autowired
	private CategoryService categoryService;
	
	@ResponseBody
	@RequestMapping("/list")
	public Map<String, Object> list() {
		List<CategoryVo> list = categoryService.getList();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
		map.put("data", list);
		
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public Map<String, Object> insert(@ModelAttribute CategoryVo vo ) {
		
		boolean result = categoryService.createCategory(vo);
		
		System.out.println("controller:" + vo);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
		map.put("data", vo);
		
		return map;
	}
	
	
//	@ResponseBody
//	@RequestMapping("/")
//	public Map<String, Object> checkId(@RequestParam(value="id", required=true, defaultValue="") String id) {
//		System.out.println(id);
//		boolean result = userService.idExists(id);
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("result", "success");
//		if( result ) {
//			map.put("data", "exist");
//		} else {
//			map.put("data", "not exist");
//		}
//		return map;
//	}

}
