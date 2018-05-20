package com.xxxx.service.service.impl;

import com.xxxx.service.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

   /* @Autowired
    private JdbcTemplate jdbcTemplate;*/

    //***************测试jdbcTemplate多数据源连接***********************
    @Autowired
    @Qualifier("firstJdbcTemplate")
    private JdbcTemplate jdbcTemplate1;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate2;
    //**************************************

    @Override
    public void createUser(String name,Integer age) {
        jdbcTemplate1.update("insert into user(name,age) values(?,?)",name,age);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate2.update("delete from user where name=?",name);
    }
}















