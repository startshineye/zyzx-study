package com.yxm.service;

import com.yxm.domain.Student;

public interface IUserService {
    public String getName(String name);
    Student getStudentById(Integer id);
    int delete(Integer id);
}
