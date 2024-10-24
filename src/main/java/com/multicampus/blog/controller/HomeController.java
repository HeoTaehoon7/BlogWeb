package com.multicampus.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public  String  home(Model model) {
		System.out.println("home");
		model.addAttribute("username", "태훈이" );
		return "/WEB-INF/views/index0.jsp";
	}
	
	@GetMapping("/html")
	public  String  html() {
		System.out.println("home");
		return "redirect:hello.html";
	}
	
	
	
}
