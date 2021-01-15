package cn.xing.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.webresources.war.Handler;

import com.mysql.jdbc.StreamingNotifiable;

import cn.xing.po.Course;
import cn.xing.po.TeacherCourse;
import cn.xing.util.DBUtil;
import cn.xing.vo.TeacherCourseView;

public class CourseDao implements ICourseDao {
	DBUtil db = new DBUtil();
	@Override
	public List<TeacherCourseView> findAllTeaCourInfo() {
		List<TeacherCourseView> lists =new ArrayList<>();
		String sql="select tc.id as tcId,tc.courseId as tcCourseId,tc.teaId as tcTeaId,tc.classId as classId,t.id as teacherId,t.name as teacherName,sc.id as stuclassId,sc.name as  stuclassName,sc.depName as departmentName,c.id as courseId,c.name as courseName from teachercourse tc,teacher t,course c,stuclass sc where tc.teaId=t.id and tc.courseId=c.id and tc.classId=sc.id";
		try {
			lists=(List)db.getQueryList(TeacherCourseView.class, sql, new Object[]{});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}

	@Override
	public Course findCourseByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TeacherCourse findTeacherCourseById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCourse(String name) {
		String sql="insert into course(name) values(?)";
		try {
			db.execute(sql, new Object[]{name});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateCourse(Course course) {
		String sql="update course set name='"+course.getName()+"' where id="+course.getId();
		try {
			db.execute(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Course findCourseById(int id) {
		String sql="select * from course where id=?";
		Course course=new Course();
		try {
			course=(Course) db.getObject(Course.class, sql, new Object[]{id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return course;
	}

	@Override
	public void addTeacherCourse(TeacherCourse tc) {
		String sql="insert into teachercourse(teaId, courseId, classId) values(?,?,?)";
		try {
			db.execute(sql, new Object[]{tc.getTeaId(),tc.getCourseId(),tc.getClassId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public TeacherCourseView findTeaCourInfoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findAllCourses() {
		
		String sql="select * from course";
		List<Course> list=new ArrayList<Course>();
		try {
			list=(List)db.getQueryList(Course.class, sql, new Object[]{});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  list;
	}

	@Override
	public List<Course> findAllCoursesByName(String name) {
		String sql="select * from course where name like '%"+name+"%'";
		List courseList = new ArrayList<Course>();
		try {
			courseList=(List)db.getQueryList(Course.class, sql, new Object[]{});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courseList;
	}

	@Override
	public boolean isExitByAllIds(TeacherCourse tc) {
		String sql="select count(*) as count from teachercourse where teaId=? and courseid=? and classId=?";
		//int result = 0;	
		Map<String , Object> result=new HashMap<>();
		//new Object[]{tc.getTeaId(),tc.getCourseId(),tc.getClassId()
		try {
				result=db.getObject(sql, new Object[]{tc.getTeaId(),tc.getCourseId(),tc.getClassId()});
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if ((int)((long) result.get("count"))>=1) {
				return false;
			}else {
				return true;				
			}
	}

	@Override
	public void updateTeacherCourse(TeacherCourse tc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TeacherCourseView> findTeaCourInfoByCourseKey(String courseKey) {
		List<TeacherCourseView> lists =new ArrayList<>();
		String sql="select tc.id as tcId,tc.courseId as tcCourseId,tc.teaId as tcTeaId,tc.classId as classId,t.id as teacherId,t.name as teacherName,sc.id as stuclassId,sc.name as  stuclassName,sc.depName as departmentName,c.id as courseId,c.name as courseName from teachercourse tc,teacher t,course c,stuclass sc where tc.teaId=t.id and tc.courseId=c.id and tc.classId=sc.id "
		+"and c.name like '%"+courseKey+"%'";
		try {
			lists=(List)db.getQueryList(TeacherCourseView.class, sql, new Object[]{});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}

	@Override
	public void deleteTourse(int tcId) {
		String sql="delete from teachercourse where id="+tcId;
		try {
			db.execute(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Course> findCourseByTeacherId(int teacherId) {
		/*SELECT * from course where id in (SELECT courseId from teachercourse where teaId =1)*/
		String sql="select * from course where id in(select courseId from teachercourse where teaId=? )";
		List<Course> courses= new ArrayList<>();
		try {
			courses=(List)db.getQueryList(Course.class, sql, new Object[]{teacherId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courses;
	}

}
