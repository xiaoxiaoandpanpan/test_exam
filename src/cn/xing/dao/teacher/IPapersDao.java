package cn.xing.dao.teacher;

import java.util.List;
import java.util.Map;

import cn.xing.po.Paper;


public interface IPapersDao {
	
	public int save(Paper  paper);
	
	public List getPaperByStudentId(int studentId,int testId);
	
	public List getPaperByStudentId(int studentId,String time);
	public List getPaperByStudentId(int studentId);
	//所有的班级成绩。
	public List getPaperCompare(int teaId);
}
