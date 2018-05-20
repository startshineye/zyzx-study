package com.xxxx.service.service.impl;

import com.xxxx.service.dao.MybatisUserMapper;
import com.xxxx.service.service.IMybatisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.persistence.RollbackException;

@Service
public class MybatisUserServiceImpl implements IMybatisUserService {
    @Autowired
    private MybatisUserMapper mybatisUserMapper;

    @Override
    @Transactional(readOnly = false,rollbackFor = RollbackException.class)
    public int createMybatisUser() {
      try {
          mybatisUserMapper.insert("加事务 事务测试1",23);
          mybatisUserMapper.insert("这是不加事务的 这是不加事务的 这是不加事务的 这是不加事务的事务测试2",23);
          return 0;
      }catch (Exception e){
          throw  new RuntimeException(e);
      }

    }
}
