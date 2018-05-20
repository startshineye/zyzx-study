package com.yxm.dao;

import com.yxm.beans.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TeacherRepository extends JpaRepository<Teacher,Integer>,JpaSpecificationExecutor<Teacher>{
}
