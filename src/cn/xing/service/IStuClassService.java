package cn.xing.service;

import java.util.List;
import java.util.Map;

import cn.xing.po.StuClass;



public interface IStuClassService {	

	public List<Map<String, Object>> findAll() ;
	
	public int addstuClass(StuClass sc);
	public void updateStuClass(StuClass sc);
	public Map<String,Object> findStuClassById(int id);
	
	public String findClassNamesByIds(String ids);
	public List<StuClass> findClassByTeacherId(int teacherId);
	
}
