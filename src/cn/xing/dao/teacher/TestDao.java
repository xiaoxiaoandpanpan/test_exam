package cn.xing.dao.teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import cn.xing.po.Test;
import cn.xing.util.DBUtil;
import cn.xing.util.ToolUtil;

public class TestDao implements ITestDao {
	private DBUtil db =new DBUtil();
	@Override
	public void createTest(Test t) {
		String sql="insert into test (name,courseId,endDate,questions,teacherId,classIds,testTime,scores) values (?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[]{ t.getName(), t.getCourseId(), t.getEndDate(), t.getQuetions(), t.getTeacherId(),t.getClassIds(),
					t.getTestTime(), t.getScores() });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Map<String, Object>> findTestsByTeaId(int teaId) {
		String currenttime = ToolUtil.getCurrentTime();
		String sql="SELECT t.id,t.name as name,c.name as courseName,t.endDate,t.questions,t.classIds,GROUP_CONCAT(sc.name) as classNames,t.testTime,t.scores  from  test t , course c , stuclass as sc where t.courseId = c.id  and FIND_IN_SET(sc.id,t.classIds) and t.teacherId = ? and t.endDate >= '"+currenttime+"' GROUP BY t.id ";
		List lists= new ArrayList<>();
		try {
			lists=db.getQueryList(sql, new Object[]{teaId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}

	@Override
	public Map<String, Object> findTestsById(int id, int teaId) {
		String sql="SELECT t.id,t.name as tName,c.name as cName,GROUP_CONCAT(sc.name) as className ,t.endDate as ensDate,t.questions,t.testTime as testTime from test t,course c,stuclass sc where t.id=? and FIND_IN_SET(sc.id,t.classIds) and t.teacherId=? and t.courseId=c.id";
		Map<String, Object> test=new HashMap<>();
		try {
			test=db.getObject(sql, new Object[]{id,teaId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return test;
	}

	@Override
	public Map<String, Object> findStudentTestsById(int studentid, int testid) {
		String sql = "SELECT t.id,t.name as testName, c.name as courseName, t.endDate,t.questions,t.testTime,t.scores, sc.name as className ,c.id as courseId from test t,student s , course c, stuclass as sc where t.id = ? and FIND_IN_SET(s.classId,t.classIds) and s.id=? and t.courseId = c.id and s.classId = sc.id";
		Map<String , Object> testMap =new HashMap<>();
		try {
			testMap=db.getObject(sql, new Object[]{testid,studentid});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (null==testMap) {
			return new HashMap<>();
		}
		return testMap;
	}

	@Override
	public List<Map<String, Object>> getTestByStudent(int id, String currData) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String[] args) {
		String ss=ToolUtil.getCurrentTime();
		System.out.println(ss);
	}
}
