package cn.xing.service.teacher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.crypto.AEADBadTagException;

import cn.xing.dao.teacher.IQuestionDao;
import cn.xing.dao.teacher.QuestionDao;
import cn.xing.po.Question;

public class QuestionService implements IQuestionService {
	private IQuestionDao questionDao = new QuestionDao(); 
	@Override
	public List<Map<String, Object>> findAll(String key, String value) {
		return questionDao.findAllQuestionInfo(key, value);
	}

	@Override
	public void addQuestion(Question q) {
		questionDao.addQuestion(q);
		
	}

	@Override
	public Map<String, Object> findQuestionById(int id) {
		return questionDao.findQuestionById(id);
	}

	@Override
	public void updateQuestionInfo(Question q) {
		questionDao.updateQuestionInfo(q);
		
	}

	@Override
	public void deleteQuestion(int id) {
		questionDao.deleteQuestion(id);
	}

	@Override
	public List<Map<String, Object>> collectQuestions(int courseId, int num) {
		List<Map<String , Object>> questionlist=questionDao.findQuestionsByCourseId(courseId);
		if(null==questionlist){
			return new ArrayList<Map<String , Object>>();
		}
		Collections.shuffle(questionlist);
		if(questionlist.size()<=num){
			return questionlist;
		}else{
			List<Map<String, Object>> newlist = new ArrayList<>();
			for(int i=0;i<num;i++){
				newlist.add(questionlist.get(i));
			}
			return newlist;
		}
	}

	@Override
	public String testQuestionIds(List<Map<String, Object>> list) {
		if (null==list||list.size()<1) {
			return "";
		} else {
			StringBuilder stringBuilder = new StringBuilder();
			for (int i = 0; i < list.size(); i++) {
				if (i==list.size()-1) {
					stringBuilder.append(list.get(i).get("id"));
				}else{
					stringBuilder.append(list.get(i).get("id")).append(",");
				}
			}
			return stringBuilder.toString();
		}
		
		
	}

	@Override
	public List<Question> findQuestionByIds(String ids) {
		return questionDao.findQuestionByIds(ids);
	}

}
