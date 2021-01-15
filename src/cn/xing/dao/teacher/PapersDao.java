package cn.xing.dao.teacher;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.mysql.jdbc.StreamingNotifiable;

import cn.xing.po.Paper;
import cn.xing.util.DBUtil;
import cn.xing.util.ToolUtil;

public class PapersDao implements IPapersDao {
	private DBUtil db = new DBUtil();
	@Override
	public int save(Paper paper) {
		String createDate = ToolUtil.getCurrentDate();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		try {
			date = formatter.parse(createDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		paper.setCreatDate(date);
		String sql = "insert into papers (testId, courseId,time,score,wrongQueId,wrongAns,studentId,createDate) values(?,?,?,?,?,?,?,?)";
		int i=0;
		try {
			i=db.execute(sql, new Object[] { paper.getTestId(), paper.getCourseId(), paper.getTime(), paper.getScore(),
					paper.getWrongQueId(), paper.getWrongAns(), paper.getStudentId(),paper.getCreatDate() });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List getPaperByStudentId(int studentId, int testId) {
		String sql="";
		return null;
	}

	@Override
	public List getPaperByStudentId(int studentId,String time) {
		String sql="SELECT t.id as testId,c.name as courseName,t.name as testName,t.endDate from  student s , test t,course c where c.id=t.courseId and FIND_IN_SET(s.classId,t.classIds) and s.id=? and t.endDate > '"+time+"'and t.id not in (SELECT papers.testId from papers) group by t.id";
		System.out.println(sql);
		List list=new ArrayList();
		try {
			list=db.getQueryList(sql, new Object[]{studentId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List getPaperCompare( int teaId) {
		String sql="SELECT p.id, AVG(p.score) as avgScore,sc.name as className , c.name as courseName,t.name as testName, t.endDate ,sc.depName from papers p, student as s , stuclass as sc , test t, course c where t.courseId = c.id and p.testId = t.id and s.classId = sc.id and s.id = p.studentId and p.testId in (SELECT t.id from test as t where t.teacherId = ?) GROUP BY className,testName ORDER BY testName";
		List paperList = new ArrayList<>();
		try {
			paperList=db.getQueryList(sql, new Object[]{teaId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paperList;
	}
public static void main(String[] args) {
	PapersDao papersDao =new PapersDao();
	//papersDao.getPaperByStudentId(1);
}

@Override
public List getPaperByStudentId(int studentId) {
	String sql = "SELECT p.time,p.score,p.createDate, t.name as testName ,c.name as courseName from papers p , test t, course c where p.testId = t.id and p.courseId = c.id and studentId = ?";
	List paperList = new ArrayList();
	try {
		paperList = db.getQueryList(sql, new Object[] { studentId });
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return paperList;
	
}
}
