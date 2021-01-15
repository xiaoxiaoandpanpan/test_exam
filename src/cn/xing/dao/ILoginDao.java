package cn.xing.dao;

import cn.xing.po.Student;
import cn.xing.po.Teacher;

public interface ILoginDao {

	public Teacher canLogin(Teacher t);
	
	public Student canLogin(Student s);
}
