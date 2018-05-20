package com.xxxx.service.service;

import com.xxxx.service.domian.Teacher;

import java.util.List;

public interface ITeacherSerivce {
    void createTeacher(Teacher teacher);
    List<Teacher>  findTeacherList();
}
