package cn.xing.service;

import java.util.List;
import java.util.Map;

import cn.xing.dao.IStudentDao;
import cn.xing.dao.StudentDao;
import cn.xing.po.Student;

public class StudentService implements IStudentService {
	
	private IStudentDao  studentDao = new StudentDao();
 
	@Override
	public void addStudent(Student s) {
		studentDao.addStudent(s);
	}

	@Override
	public void updateStudent(Student s) {
		studentDao.updateStudent(s);
	}

	@Override
	public Student findStudentById(int id) {
		return studentDao.findStudentById(id);
	}

	@Override
	public List<Map<String, Object>> findAll() {
		
		List<Map<String, Object>> studentList= studentDao.findAll();
		return studentList;
	}

	@Override
	public List<Student> studentList(String name) {
		// TODO Auto-generated method stub
		return studentDao.studentList(name);
	}

}
