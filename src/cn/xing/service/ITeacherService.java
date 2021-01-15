package cn.xing.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.xing.po.Teacher;

public interface ITeacherService {		

	public List<Map<String,Object>> findAll();
	public List<Teacher> teacherList(String name);
	public void addTeacher(Teacher teacher);
	public void updateTeacher(Teacher teacher,int oldid);
	public Map<String,Object> findTeacherInfo(int id) ;
	
	public List<Map<String, Object>> findClassesByTeacherId(int teacherId);
}
