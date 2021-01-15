package cn.xing.vo;
/**
 * 教师课程信息视图类
 * @author Administrator
 *
 */
public class TeacherCourseView {
	//老师教课(teachercourse)
	private int  tcId;//id
	private int  tcCourseId;//courseId
	private int  tcTeaId; //teaId
	private int classId;//classId
	
	//教师(teacher)
	private int  teacherId;//id
	private String  teacherName;//name
	
	//班级(stuclass表)
	private int  stuclassId;//id
	private String  stuclassName;//name
	//private int  departmentId;
	private String  departmentName;//depName
	//课程(course)
	private int  courseId;//id
	private String  courseName;//name
	
	public int getTcId() {
		return tcId;
	}
	public void setTcId(int tcId) {
		this.tcId = tcId;
	}
	public int getTcCourseId() {
		return tcCourseId;
	}
	public void setTcCourseId(int tcCourseId) {
		this.tcCourseId = tcCourseId;
	}
	public int getTcTeaId() {
		return tcTeaId;
	}
	public void setTcTeaId(int tcTeaId) {
		this.tcTeaId = tcTeaId;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public int getStuclassId() {
		return stuclassId;
	}
	public void setStuclassId(int stuclassId) {
		this.stuclassId = stuclassId;
	}
	public String getStuclassName() {
		return stuclassName;
	}
	public void setStuclassName(String stuclassName) {
		this.stuclassName = stuclassName;
	}

	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	
}
