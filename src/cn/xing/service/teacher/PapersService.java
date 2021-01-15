package cn.xing.service.teacher;

import java.util.List;

import cn.xing.dao.teacher.IPapersDao;
import cn.xing.dao.teacher.PapersDao;
import cn.xing.po.Paper;

public class PapersService implements IPaperService {
	private IPapersDao paperDao = new PapersDao(); 
	@Override
	public int save(Paper paper) {
		return paperDao.save(paper);
	}

	@Override
	public List getPaperByStudentId(int studentId, int testId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getPaperByStudentId(int studentId,String time) {
		return paperDao.getPaperByStudentId(studentId,time);
	}

	@Override
	public List getPaperCompare(int id) {
		// TODO Auto-generated method stub
		return paperDao.getPaperCompare(id);
	}

	@Override
	public List getPaperByStudentId(int studentId) {
		// TODO Auto-generated method stub
		return paperDao.getPaperByStudentId(studentId);
	}

}
