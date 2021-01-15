package cn.xing.service.teacher;

import java.util.List;

import cn.xing.po.Paper;



public interface IPaperService { 
	
	public int save(Paper paper);
	/**
	 * 学生试题
	 * @return
	 */
	public List getPaperByStudentId(int studentId,int testId);
	
	/**
	 * 学生以往答过的试卷
	 * @return
	 */
	public List getPaperByStudentId(int studentId,String time);
	public List getPaperByStudentId(int studentId);
	public List getPaperCompare(int id);
}
