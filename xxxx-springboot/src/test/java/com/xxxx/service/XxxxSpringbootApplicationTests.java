package com.xxxx.service;

import com.xxxx.service.dao.MybatisUserMapper;
import com.xxxx.service.domian.Student;
import com.xxxx.service.domian.Teacher;
import com.xxxx.service.service.IMybatisUserService;
import com.xxxx.service.service.ITeacherSerivce;
import com.xxxx.service.service.IUserService;
import com.xxxx.service.task.AsyncTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XxxxSpringbootApplicationTests {
	@Autowired
	private Student stu;
	@Autowired
	private IUserService userService;

	@Autowired
	private ITeacherSerivce teacherService;

	@Autowired
	private MybatisUserMapper mybatisUserMapper;

	@Autowired
	private IMybatisUserService mybatisUserService;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Autowired
	private AsyncTask asyncTask;
	@Test
	public void contextLoads() {
		//带返回值的异步回调
		//用future.get()来获取异步任务的返回结果
			Future<String> future = asyncTask.haveReturnTask();
			System.out.println("begin to deal other Task!");
			try {
				while (true) {
					if (future.isCancelled()) {
						System.out.println("deal async task is Cancelled");
						break;
					}
					if (future.isDone()) {
						System.out.println("deal async task is Done");
						System.out.println("return result is " + future.get());
						break;
					}
					System.out.println("wait async task to end ...");
					Thread.sleep(1000);
				}
			}catch (Exception e){
				e.printStackTrace();
			}

		//事务操作
		//mybatisUserService.createMybatisUser();



		//redis操作Stirng
		/*stringRedisTemplate.opsForValue().set("key1","aaaaaaaaa");
		stringRedisTemplate.opsForValue().set("key2","bbbbbbbbb");
		System.out.println("key1:"+stringRedisTemplate.opsForValue().get("key1")+"key2:"+stringRedisTemplate.opsForValue().get("key2"));
*/
		//redis操作对象
		/*Student stu = new Student();
		stu.setName("lisi");
		stu.setAge(24);

 		redisTemplate.opsForValue().set(stu.getName(), stu);
		Student t2=(Student)redisTemplate.opsForValue().get(stu.getName());
 		System.out.println("redis操作对象: "+t2.getName()+"  "+t2.getAge());
*/
		//System.out.println("student name:"+stu.getName()+" student age:"+stu.getAge());
		//userService.createUser("zs",23);
		/*userService.deleteByName("zs");

		//createTeacher
		Teacher teacher = new Teacher();
		teacher.setName("lisi");
		teacher.setAge(24);
		teacherService.createTeacher(teacher);

		//findTeacherList
		List<Teacher> teacherList = teacherService.findTeacherList();
		for(Teacher tc:teacherList){
             System.out.println(tc.getName()+" "+tc.getAge());
		}*/

		//多数据源测试
        //userService.createUser("zsf",100);
		//userService.deleteByName("zsf");

		//mybatis集成测试
		/*mybatisUserMapper.insert("zs",23);
		mybatisUserMapper.insert("ls",24);
		mybatisUserMapper.insert("ww",25);
		mybatisUserMapper.insert("zl",26);*/

	}
}

















