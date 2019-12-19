package com.demo.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.demo.model.StudentName;

@Repository
public class StudentNameDao {
	
	private static Map<Integer,StudentName> studentNames = null;
	
	static {
		studentNames = new HashMap<Integer, StudentName>();
		studentNames.put(101, new StudentName(101,"张三",21,"zhangsan@163.com","上海虹桥"));
		studentNames.put(101, new StudentName(102,"李四",21,"zhangsan@163.com","上海虹桥"));
		studentNames.put(101, new StudentName(103,"王五",21,"zhangsan@163.com","上海虹桥"));
		studentNames.put(101, new StudentName(104,"小刘",21,"zhangsan@163.com","上海虹桥"));
		studentNames.put(101, new StudentName(105,"老赵",21,"zhangsan@163.com","上海虹桥"));
		studentNames.put(101, new StudentName(106,"徐福记",21,"zhangsan@163.com","上海虹桥"));
		studentNames.put(101, new StudentName(107,"周黑鸭",21,"zhangsan@163.com","上海虹桥"));
	}
	
	public StudentName getStudentNameById(Integer id) {
		return studentNames.get(id);
	}
	
	public Collection<StudentName> getStudentNameList(){
		return studentNames.values();
	}

}
