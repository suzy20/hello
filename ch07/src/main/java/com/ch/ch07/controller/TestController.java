package com.ch.ch07.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	@RequestMapping("aa")
	public String aa() {
		return "aa";
	}
	@RequestMapping("loginForm")
	public String loginForm() {
		return "loginForm";
	}
	@RequestMapping("login")
	public String login(String id, String password, 
			Model model, HttpSession session) {
		int result = 0;
		if(id.equals("java") && password.equals("1234")) {
			session.setAttribute("id", id);
			result = 1;
		}
		model.addAttribute("result", result);
		return "login";
	}
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		// invalidate는 session의 데이터를 삭제해라 
		session.invalidate();
		return "loginForm";
	}
}
