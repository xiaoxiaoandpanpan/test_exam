package cn.xing.service.teacher;

import java.util.List;
import java.util.Map;

import cn.xing.dao.teacher.ITestDao;
import cn.xing.dao.teacher.TestDao;
import cn.xing.po.Test;

public class TestService implements ITestService {
	private ITestDao testDao = new TestDao();

	@Override
	public void createTest(Test t) {
		testDao.createTest(t);
	}

	@Override
	public List<Map<String, Object>> findTestsByTeaId(int teaId) {
		// TODO Auto-generated method stub
		return testDao.findTestsByTeaId(teaId);
	}

	@Override
	public Map<String, Object> findTestsById(int id, int teaId) {
		return testDao.findTestsById(id, teaId);
	}

	@Override
	public Map<String, Object> findStudentTestsById(int studentid, int testid) {
		// TODO Auto-generated method stub
		return testDao.findStudentTestsById(studentid, testid);
	}

	@Override
	public List<Map<String, Object>> getTestByStudent(int id, String currData) {
		// TODO Auto-generated method stub
		return null;
	}

}
