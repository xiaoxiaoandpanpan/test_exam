package cn.xing.service;

import java.util.List;
import java.util.Map;

import cn.xing.dao.ITeacherDao;
import cn.xing.dao.TeacherDao;
import cn.xing.po.Teacher;

public class TeacherService implements ITeacherService {
	private	ITeacherDao teacherDao = new TeacherDao();
	@Override
	public List<Map<String, Object>> findAll() {
		return teacherDao.findAllTeacherInfo() ;
	}

	@Override
	public List<Teacher> teacherList(String name) {
		
		return teacherDao.findTeacherByName(name);
	}

	@Override
	public void addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		teacherDao.addTeacher(teacher);
	}

	@Override
	public void updateTeacher(Teacher teacher, int oldid) {
		teacherDao.updateTeacher(teacher, oldid);
		
	}

	@Override
	public Map<String, Object> findTeacherInfo(int id) {
		return	 teacherDao.findTeacherInfo(id);
	}

	@Override
	public List<Map<String, Object>> findClassesByTeacherId(int teacherId) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
