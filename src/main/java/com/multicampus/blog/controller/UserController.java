package com.multicampus.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.multicampus.blog.dto.ResponseDTO;
import com.multicampus.blog.model.User;
import com.multicampus.blog.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/auth/insertUser") 
	public String insertUser() {
		return "user/insertUser";
	}
	
	@PostMapping("/auth/insertUser")
	public @ResponseBody ResponseDTO<?> insertUser(@RequestBody User user) {
		User findUser = userService.getUser(user.getUsername());

		if(findUser.getUsername() == null) {
			userService.insertUser(user);
			return new ResponseDTO<>(HttpStatus.OK.value(), user.getUsername() + "님 회원가입 성공하셨습니다.!");
		} else {
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), user.getUsername() + "님은 이미 회원입니다.!");			
		}
	}


}
