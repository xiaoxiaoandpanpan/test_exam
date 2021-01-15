package cn.xing.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.xing.po.StuClass;



public interface IStuClassDao {

	public List<Map<String, Object>> findAllStuClassInfo();

	public Map<String, Object> findStuClassById(int classId) ;

	public int addStuClassById(StuClass sc) ;

	public void updateStuClassById(StuClass sc) ;
	
	public String findClassNamesByIds(String ids);
	
	
	public List<String> classNameAll();
	
	public List<StuClass> findClassByTeacherId(int tId);
}
