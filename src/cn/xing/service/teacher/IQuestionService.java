package cn.xing.service.teacher;
 
import java.util.List;
import java.util.Map;

import cn.xing.po.Question;



public interface IQuestionService {
	 

	public List<Map<String,Object>> findAll(String key, String value);
	
	public void addQuestion(Question q);
	
	public Map<String, Object> findQuestionById(int id);
	
	public void updateQuestionInfo(Question q);
	
	public void deleteQuestion(int id);
	
	
	//生成试卷，需要的信息，考试科目
	public List<Map<String, Object>> collectQuestions(int courseId,int num);
	
	public String testQuestionIds(List<Map<String, Object>> list);
	
	public List<Question> findQuestionByIds(String ids) ;
}
