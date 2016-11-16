package com.bit2016.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit2016.jblog.service.UserService;
import com.bit2016.jblog.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/joinform")
	public String joinform(@ModelAttribute UserVo userVo) {
		
		return "user/join";
	}
	
	@RequestMapping("/join")
	public String join( @ModelAttribute UserVo vo) {
		userService.join(vo);
		return "redirect:/user/joinsuccess";
	}
	
	@RequestMapping("/joinsuccess")
	public String joinSuccess() {
		
		return "user/joinsuccess";
	}
	
	@RequestMapping("/loginform")
	public String loginform() {
		return "user/login";
	}
	
/*	@RequestMapping("/login")
	public String login(@ModelAttribute UserVo userVo2,
		HttpSession session){


		UserVo userVo = null;
		userVo = userService.login(userVo2.getId(), userVo2.getPassword());
		if ( userVo == null ) {
			return "redirect:/user/loginform?result=fail";
		}
		//인증처리
		session.setAttribute("authUser", userVo);
		return "redirect:/";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "redirect:/";
	}*/
	
}
