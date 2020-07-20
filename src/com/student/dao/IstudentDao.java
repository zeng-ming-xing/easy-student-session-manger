package com.student.dao;

import java.util.List;

import com.student.vo.Student;


public interface IstudentDao {

	public int add(Student stu);
	public List<Student> findall();
	public int deleted(int id);
	public List<Student> find(int id); 
	public int update(Student stu);
	
}