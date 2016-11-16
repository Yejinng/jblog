package com.bit2016.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bit2016.jblog.service.BlogService;
import com.bit2016.jblog.service.UserService;
import com.bit2016.jblog.vo.BlogVo;
import com.bit2016.jblog.vo.UserVo;
import com.bit2016.security.Auth;
import com.bit2016.security.AuthUser;

@Controller
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/{userId}")
	public String index(@AuthUser UserVo authUser, @PathVariable("userId") String userId, Model model) {
		BlogVo vo = blogService.getInfo(authUser.getUserNo());
		model.addAttribute("userId", userId);
		model.addAttribute("blogVo",vo);
		return "blog/blog-main";
	}
	
	@Auth
	@RequestMapping("/{userId}/admin/basic/modify")
	public String adminBasicForm(@AuthUser UserVo authUser, @PathVariable("userId") String userId, Model model) {
		BlogVo vo = blogService.getInfo(authUser.getUserNo());
		model.addAttribute("userId", userId);
		model.addAttribute("blogVo",vo);
		return "blog/blog-admin-basic";
	}
	
	@Auth
	@RequestMapping("/admin/basic")
	public String adminBasic(@AuthUser UserVo authUser,
			@RequestParam(value="title", required=true, defaultValue="(내용없음)") String title,
			@RequestParam(value="logo-file") MultipartFile file, 
			@RequestParam(value="logo", required=true, defaultValue="default") String logo ,Model model) {

		String url1 = blogService.restore(file, title, authUser.getUserNo(),logo);
		//model.addAttribute("url1", url1);
		return "redirect:/" + authUser.getId() + "/admin/basic/modify";
	}
	
	
	@RequestMapping("/{userId}/admin/category")
	public String adminCategory(@PathVariable("userId") String userId, Model model) {
		System.out.println(userId);
		model.addAttribute("userId", userId);
		return "blog/blog-admin-category";
	}
	
	@RequestMapping("/{userId}/admin/write")
	public String adminWrite(@PathVariable("userId") String userId, Model model) {
		System.out.println(userId);
		model.addAttribute("userId", userId);
		return "blog/blog-admin-write";
	}
	
	
	
}
