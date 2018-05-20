package com.xxxx.service.service.impl;

import com.xxxx.service.dao.TeacherRepository;
import com.xxxx.service.domian.Teacher;
import com.xxxx.service.service.ITeacherSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherSerivce {
    @Autowired
    private TeacherRepository repository;

    @Override
    public void createTeacher(Teacher teacher) {
        repository.save(teacher);
        //*********************演示不加事务**************************
        /*Teacher teacher1 = new Teacher();
        teacher1.setAge(24);
        teacher1.setName("不加事务测试1");
        repository.save(teacher);

        Teacher teacher2 = new Teacher();
        teacher2.setAge(24);
        teacher2.setName("数据长度超过20的 不加事务测试2");
        repository.save(teacher);*/
        //*********************演示不加事务**************************
    }

    @Override
    public List<Teacher> findTeacherList() {
        return repository.findAll();
    }
}
