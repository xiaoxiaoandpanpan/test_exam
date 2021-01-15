package cn.xing.dao.teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.el.ArrayELResolver;

import cn.xing.po.Question;
import cn.xing.util.DBUtil;

public class QuestionDao implements IQuestionDao {
	private DBUtil db= new DBUtil();
	@Override
	public List<Map<String, Object>> findAllQuestionInfo(String key, String value) {
		StringBuilder sql= new StringBuilder();
		sql.append("SELECT que.id,c.`name`,que.queTitle,que.choiceA,que.choiceB,que.choiceC,que.choiceD,que.ans, que.queExist  from questions que,course c WHERE que.queExist=1 and que.courseId=c.id");
		
		if (key!=null&&value!=null&&!"".equals(key.trim())&&!"".equals(value.trim())) {
			sql.append(" and "+key+" like '%"+value+"%'");
		}
		List<Map<String , Object>> lists= new ArrayList<Map<String , Object>>();
		try {
			
			lists=db.getQueryList(sql.toString());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}

	@Override
	public void addQuestion(Question q) {
		String sql = "insert into questions (courseId,queType,queTitle,choiceA,choiceB,choiceC,choiceD,ans,queExist) values (?,?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[] { q.getCourseId(), q.getQueType(), q.getQueTitle(), q.getChoiceA(),
					q.getChoiceB(), q.getChoiceC(), q.getChoiceD(), q.getAns(),q.getQueExist() });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> findQuestionById(int id) {
		String sql="select * from questions where id="+id;
		Map<String , Object> question= new HashMap<>();
		try {
			question=db.getObject(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return question;
	}

	@Override
	public List<Question> findQuestionByIds(String ids) {
		String sql="select * from questions where FIND_IN_SET(id,?)";
		List questions = new ArrayList<>();
		try {
			questions=db.getQueryList(Question.class, sql, new Object[]{ids});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return questions;
	}

	@Override
	public void updateQuestionInfo(Question q) {
		String sql="update questions set courseId=?,queTitle=?,choiceA=?,choiceB=?,choiceC=?,choiceD=?,ans=? where id=?";
		try {
			System.out.println(sql);
			db.execute(sql, new Object[]{q.getCourseId(),q.getQueTitle(),q.getChoiceA(),q.getChoiceB(),q.getChoiceC(),q.getChoiceD(),q.getAns(),q.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Map<String, Object>> findQuestionsByCourseId(int courseId) {
		String sql="select * from questions where courseId=? order by id desc";
		List<Map<String , Object>> list = new ArrayList<>();
		try {
			list=db.getQueryList(sql, new Object[]{courseId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void deleteQuestion(int id) {
		String sql="update questions set queExist=2 where id=?";
		try {
			System.out.println(sql);
			db.execute(sql, new Object[]{id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		QuestionDao qq= new QuestionDao();
		qq.findAllQuestionInfo("", "");
	}
}
