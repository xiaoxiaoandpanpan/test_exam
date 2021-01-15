package cn.xing.dao;

import cn.xing.po.Student;
import cn.xing.po.Teacher;
import cn.xing.util.DBUtil;

public class LoginDao implements ILoginDao {

	private DBUtil db= new DBUtil();
	@Override
	public Teacher canLogin(Teacher t) {
	    String sql="select * from teacher where name=? and pwd=?";
	    Teacher teacher=new Teacher();
	    try {
			teacher=(Teacher) db.getObject(Teacher.class, sql, new Object[]{t.getName(),t.getPwd()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (teacher!=null) {
			return teacher;
		} else {
			return null;
		}
	}

	@Override
	public Student canLogin(Student s) {
		  String sql="select * from student where name=? and pwd=?";
		    Student student = new Student();
		    try {
				student=(Student) db.getObject(Student.class, sql, new Object[]{s.getName(),s.getPwd()});
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (student!=null) {
				return student;
			} else {
				return null;
			}
	}
	public static void main(String[] args) {
		Teacher teacher=new Teacher();
		teacher.setName("123");
		teacher.setPwd("13");
		LoginDao ll=new LoginDao();
		System.out.println(ll.canLogin(teacher));
	}
}

