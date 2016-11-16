package com.bit2016.jblog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit2016.jblog.service.BlogService;

@Controller("blogAPIController")
@RequestMapping("/blog/api")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
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
