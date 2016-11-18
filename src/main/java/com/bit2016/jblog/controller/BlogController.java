package com.bit2016.jblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bit2016.jblog.service.BlogService;
import com.bit2016.jblog.service.CategoryService;
import com.bit2016.jblog.service.PostService;
import com.bit2016.jblog.vo.BlogVo;
import com.bit2016.jblog.vo.CategoryVo;
import com.bit2016.jblog.vo.PostVo;
import com.bit2016.jblog.vo.UserVo;
import com.bit2016.security.Auth;
import com.bit2016.security.AuthUser;

@Controller
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	@Autowired
	private CategoryService categoryService;
	@Autowired 
	private PostService postService;
	
	@RequestMapping("/{userId}")
	public String index(@PathVariable("userId") String userId, Model model) {
		BlogVo vo = blogService.getInfo(userId);
		List<CategoryVo> categoryList = categoryService.categoryList(vo.getUserNo());
		List<PostVo> postList = postService.postList(vo.getUserNo(), null);
		model.addAttribute("userId", userId);
		model.addAttribute("blogVo",vo);
		model.addAttribute("categoryList",categoryList);
		model.addAttribute("postList", postList);
		return "blog/blog-main";
	}
	
	@RequestMapping("/{userId}/category/{categoryNo}")
	public String postList(@PathVariable("userId") String userId,
			@PathVariable("categoryNo") Long categoryNo, Model model) {
		BlogVo vo = blogService.getInfo(userId);
		List<CategoryVo> categoryList = categoryService.categoryList(vo.getUserNo());
		List<PostVo> postList = postService.postList(vo.getUserNo(), categoryNo);
		model.addAttribute("userId", userId);
		model.addAttribute("blogVo",vo);
		model.addAttribute("categoryList",categoryList);
		model.addAttribute("postList", postList);
		return "blog/blog-main";
	}
	
	@RequestMapping("/{userId}/{postNo}")
	public String postView(@PathVariable("userId") String userId,
			@PathVariable("postNo") Long postNo, Model model) {
		BlogVo vo = blogService.getInfo(userId);
		PostVo postVo = postService.get(postNo);
		List<CategoryVo> categoryList = categoryService.categoryList(vo.getUserNo());
		List<PostVo> postList = postService.postList(vo.getUserNo(), postVo.getCategoryNo());
		model.addAttribute("userId", userId);
		model.addAttribute("blogVo",vo);
		model.addAttribute("postVo",postVo);
		model.addAttribute("categoryList",categoryList);
		model.addAttribute("postList", postList);
		return "blog/blog-main";
	}
	
//--------------------------------------------블로그 관리---------------------------------------------
	@Auth
	@RequestMapping("/{userId}/admin/basic/modify")
	public String adminBasicForm(@AuthUser UserVo authUser, @PathVariable("userId") String userId, Model model) {
		BlogVo vo = blogService.getInfo(userId);
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
		blogService.restore(file, title, authUser.getUserNo(),logo);
		return "redirect:/" + authUser.getId() + "/admin/basic/modify";
	}
	
	@RequestMapping("/{userId}/admin/category")
	public String adminCategory(@AuthUser UserVo authUser, @PathVariable("userId") String userId, Model model) {
		//System.out.println("컨트롤러 카테고리");
		BlogVo vo = blogService.getInfo(userId);
		//System.out.println("authUserNo: " +authUser.getUserNo());
		List<CategoryVo> list = categoryService.categoryList(authUser.getUserNo());
		//System.out.println(list);
		model.addAttribute("list", list);
		model.addAttribute("userId", userId);
		model.addAttribute("blogVo",vo);
		return "blog/blog-admin-category";
	}
	
	@RequestMapping(value="/{userId}/admin/write" , method=RequestMethod.GET)
	public String adminWriteform(@AuthUser UserVo authUser, @PathVariable("userId") String userId,
			@ModelAttribute PostVo postVo, Model model) {
		System.out.println(userId);
		BlogVo vo = blogService.getInfo(userId);
		List<CategoryVo> list = categoryService.categoryList(authUser.getUserNo());
		model.addAttribute("userId", userId);
		model.addAttribute("list", list);
		model.addAttribute("blogVo",vo);
		return "blog/blog-admin-write";
	}
	
	@RequestMapping(value="/{userId}/admin/write" , method=RequestMethod.POST)
	public String adminWrite(@AuthUser UserVo authUser, @PathVariable("userId") String userId,
			@ModelAttribute PostVo postVo, Model model) {
		System.out.println(postVo);
		postService.write(postVo);

		return "redirect:/" + authUser.getId();
		//return "redirect:/"+authUser.getId()+"/"+postVo.getPostNo();
	}
	
	
	
}
