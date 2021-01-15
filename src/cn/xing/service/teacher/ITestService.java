package cn.xing.service.teacher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import cn.xing.po.Test;


public interface ITestService { 

	public void createTest(Test t) ;

	/**
	 * 返回试卷信息
	 * 
	 * @param teaId
	 * @return
	 */
	public List<Map<String, Object>> findTestsByTeaId(int teaId) ;

	public Map<String, Object> findTestsById(int id, int teaId);
	public Map<String, Object> findStudentTestsById(int studentid,int testid) ;
	public List<Map<String, Object>> getTestByStudent(int id, String currData);
	
}
