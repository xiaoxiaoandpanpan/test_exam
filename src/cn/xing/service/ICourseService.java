package cn.xing.service;

import java.util.List;

import cn.xing.po.Course;
import cn.xing.po.TeacherCourse;
import cn.xing.vo.TeacherCourseView;



public interface ICourseService {
	
	public List<TeacherCourseView> findAll();

	public TeacherCourseView findTeacherCourseById(int id);
	
	public Course findCourseById(int id) ;
	
	public List<Course> findAllCourses() ;
	
	public List<Course> findAllCourses(String name);


	
	/**
	 * 先判断一下是否存在，如果不存在，直接插入操作，如果存在，则更新
	 * 
	 * @param teaCourID
	 *            映射ID号，自增长
	 * @param courseId
	 * @param teaId
	 * @param stuClassId
	 * @return
	 */
	public boolean modifyTeacherCourse(TeacherCourse tc);
	
	public List<TeacherCourseView> findTeacherCourseByKey(String courseKey);
	
	public void deleteTeacherCourse(int tcId);
	
	/**
	 * 添加课程信息
	 * @return
	 */
	public void addCourse(String courseName);
	
	/**
	 * 添加课程信息
	 * @return
	 */
	public void updateCourse(Course course);
	
	/**
	 * 添加排课信息，包括老师，班级，和课程。
	 * @return
	 */
	public void addSchedule(TeacherCourse tc);
	
	public List<Course> findCourseByTeacherId(int teacherId);
}
