package cn.xing.service;

import java.util.List;
import java.util.Map;

import cn.xing.dao.IStuClassDao;
import cn.xing.dao.StuClassDao;
import cn.xing.po.StuClass;

public class StuClassService implements IStuClassService {
	
	private	IStuClassDao stuClassDao = new StuClassDao();
	@Override
	public List<Map<String, Object>> findAll() {
		return stuClassDao.findAllStuClassInfo();
	}

	@Override
	public int addstuClass(StuClass sc) {		
		int result=stuClassDao.addStuClassById(sc);
		return result;
	}

	@Override
	public void updateStuClass(StuClass sc) {

		stuClassDao.updateStuClassById(sc);
	}

	@Override
	public Map<String, Object> findStuClassById(int id) {
		return 	stuClassDao.findStuClassById(id);
	}

	@Override
	public String findClassNamesByIds(String ids) {
		return stuClassDao.findClassNamesByIds(ids);
	}

	@Override
	public List<StuClass> findClassByTeacherId(int teacherId) {
		// TODO Auto-generated method stub
		return stuClassDao.findClassByTeacherId(teacherId);
	}

}
