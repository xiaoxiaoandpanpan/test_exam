package cn.xing.service;

import java.util.List;
import java.util.Map;

import cn.xing.po.Student;

public interface IStudentService { 
	public void addStudent(Student s);
	public void updateStudent(Student s);
	public Student findStudentById(int id);
	public List<Map<String,Object>> findAll();
	public List<Student> studentList(String name);
}
