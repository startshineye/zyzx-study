package com.xxxx.service.dao;

import com.xxxx.service.domian.MybatisUser;
import org.apache.ibatis.annotations.*;

import java.util.Map;

@Mapper
public interface MybatisUserMapper {
    @Select("select * from mybatis_user where name=#{name}")
    MybatisUser findByName(@Param("name") String name);

    @Insert("insert into mybatis_user(name,age) values(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    //以map形式接受参数
    @Insert("INSERT INTO mybatis_user(NAME, AGE) VALUES(#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    //以实体类形式接受参数
    @Insert("INSERT INTO mybatis_user(NAME, AGE) VALUES(#{name}, #{age})")
    int insertByMybatisUser(MybatisUser user);

    //更新
    @Update("update mybatis_user set age=30 where id=#{id}")
    void update(@Param("id") Integer id);

    //删除
    @Delete("DELETE FROM mybatis_user WHERE id =#{id}")
    void delete(Integer id);
}
