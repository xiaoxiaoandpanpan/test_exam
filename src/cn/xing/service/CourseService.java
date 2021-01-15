package cn.xing.service;

import java.util.List;

import cn.xing.dao.CourseDao;
import cn.xing.dao.ICourseDao;
import cn.xing.po.Course;
import cn.xing.po.TeacherCourse;
import cn.xing.vo.TeacherCourseView;

public class CourseService implements ICourseService {
	private ICourseDao courseDao = new CourseDao();

	@Override
	public List<TeacherCourseView> findAll() {
		return courseDao.findAllTeaCourInfo();
	}

	@Override
	public TeacherCourseView findTeacherCourseById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course findCourseById(int id) {
		return courseDao.findCourseById(id);
	}

	@Override
	public List<Course> findAllCourses() {
		return  courseDao.findAllCourses();
	}

	@Override
	public List<Course> findAllCourses(String name) {
		return courseDao.findAllCoursesByName(name);
	}

	@Override
	public boolean modifyTeacherCourse(TeacherCourse tc) {
		if (courseDao.isExitByAllIds(tc)) {
			courseDao.addTeacherCourse(tc);
			return true;
		}else{
			return false;			
		}
	}

	@Override
	public List<TeacherCourseView> findTeacherCourseByKey(String courseKey) {
		return courseDao.findTeaCourInfoByCourseKey(courseKey);
	}

	@Override
	public void deleteTeacherCourse(int tcId) {
		courseDao.deleteTourse(tcId);
	}

	@Override
	public void addCourse(String courseName) {
		courseDao.addCourse(courseName);
	}

	@Override
	public void updateCourse(Course course) {
		courseDao.updateCourse(course);
	}

	@Override
	public void addSchedule(TeacherCourse tc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Course> findCourseByTeacherId(int teacherId) {
		// TODO Auto-generated method stub
		return courseDao.findCourseByTeacherId(teacherId);
	}

}
