package cn.xing.service;

import cn.xing.dao.ILoginDao;
import cn.xing.dao.LoginDao;
import cn.xing.po.Student;
import cn.xing.po.Teacher;

public class LoginService implements ILoginService {

	private ILoginDao login = new LoginDao();
	@Override
	public Teacher canLogin(Teacher t) {
		return login.canLogin(t);
	}

	@Override
	public Student canLogin(Student s) {
		return login.canLogin(s);
	}

}
