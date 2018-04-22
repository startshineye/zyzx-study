package com.yxm.service.Impl;

import com.yxm.dao.StudentMapper;
import com.yxm.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yxm.service.IUserService;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource
	private StudentMapper studentMapper;

	public String getName(String name) {
		// TODO Auto-generated method stub
		return name;
	}

	public Student getStudentById(Integer id) {
		return studentMapper.selectByPrimaryKey(id);
	}

	public int delete(Integer id) {
		return studentMapper.deleteByPrimaryKey(id);
	}

}
