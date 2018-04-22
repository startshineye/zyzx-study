package com.yxm.controller;

import javax.annotation.Resource;

import com.yxm.domain.Student;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yxm.service.IUserService;


@Controller
@RequestMapping("/user")
public class UserController {
     Logger logger = Logger.getLogger(UserController.class);
	 @Resource
	 private IUserService userService;
	 
	 
	 @RequestMapping("/getname")
	 @ResponseBody
	 public String getName(){
		logger.info("==info== UserController 中的 getName方法执行");
		logger.error("==error== UserController 中的 getName方法执行");
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
