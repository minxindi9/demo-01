package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.demo.model.StudentName;

@Mapper
public interface NameMapper {
	
	@Select("select * from name")
	public List<StudentName> getNameList();

}
