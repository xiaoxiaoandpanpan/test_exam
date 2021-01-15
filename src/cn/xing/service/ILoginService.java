package cn.xing.service;

import cn.xing.po.Student;
import cn.xing.po.Teacher;

/**
 * 通过登录信息判断是否能够成功登录
 * @author yangzhen
 *
 */
public interface ILoginService {

	public Teacher canLogin(Teacher t);
	public Student canLogin(Student s);
}
