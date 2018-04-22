package com.yxm.controller;

import javax.annotation.Resource;

import com.yxm.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yxm.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
     
	 @Resource
	 private IUserService userService;
	 
	 
	 @RequestMapping("/getname")
	 @ResponseBody
	 public String getName(){
		 return userService.getName("aaa");
	 }

	@RequestMapping("/getNameById")
	@ResponseBody
	 public Student getStudent(){
       return userService.getStudentById(1);
	 }
	@RequestMapping("/delete")
	@ResponseBody
	public int delete(){
		return userService.delete(1);
	}
}
