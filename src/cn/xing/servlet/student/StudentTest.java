package cn.xing.servlet.student;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.RepaintManager;

import cn.xing.po.Paper;
import cn.xing.po.Question;
import cn.xing.po.Student;
import cn.xing.service.teacher.IPaperService;
import cn.xing.service.teacher.IQuestionService;
import cn.xing.service.teacher.ITestService;
import cn.xing.service.teacher.PapersService;
import cn.xing.service.teacher.QuestionService;
import cn.xing.service.teacher.TestService;

@WebServlet("/studentTest")
public class StudentTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  IPaperService paperService = new PapersService();
	private ITestService testService = new TestService();
	private IQuestionService questionService = new QuestionService();

    public StudentTest() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String testId=request.getParameter("testId");
		Student student =(Student) request.getSession().getAttribute("user");
		Map<String , Object> test = testService.findStudentTestsById(student.getId(), Integer.parseInt(testId));
		List<Question> questionList =questionService.findQuestionByIds((String)test.get("questions"));
		double ss= 1.0*Integer.parseInt(      ((String)test.get("scores")))/questionList.size();
		System.out.println("-->"+ss);
		request.setAttribute("scoreperques", 1.0*Integer.parseInt(((String)test.get("scores")))/questionList.size());
		
		request.getSession().setAttribute("test", test);
		request.getSession().setAttribute("quesList", questionList);
		
		request.getRequestDispatcher("/student/exam.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取时间
		String time =request.getParameter("hidden1");
		//从sesion中获取试题信息
		List<Question> questionList =(List<Question>) request.getSession().getAttribute("quesList");
		Map<String, Object> testMap=(Map<String, Object>) request.getSession().getAttribute("test");
		if (null==questionList||questionList.size()<1) {
			return  ;
		}
		StringBuilder wrongQueId=new StringBuilder();
		StringBuilder wrongAns=new StringBuilder();
		
		int wrongQueNum=0;
		
		for(int i=0;i<questionList.size();i++){
			Question question=questionList.get(i);
			String ans = request.getParameter("ques_"+question.getId()).toUpperCase();
			if (!question.getAns().equals(ans)) {
				wrongQueId.append(question.getId()).append(",");
				wrongAns.append(ans).append(",");
				wrongQueNum++;
			}
		}
		Paper p = new Paper();
		p.setTestId((int) testMap.get("id"));
		p.setCourseId((int) testMap.get("courseId"));
		p.setTime(time);
		//获得试题的总分和错误试题的数量
		if (questionList.size()>wrongQueNum)
			p.setScore(1.0*Integer.parseInt((String) (testMap.get("scores")))/questionList.size()*(questionList.size()-wrongQueNum));
		else
			p.setScore(0);
		/**
		 * 如果做的全对，那么wrongQueId和wrongAns，都是空
		 * 如果有错题，那么多带了一个逗号
		 */
		String wrongQueIdString = wrongQueId.toString();
		String wrongAnsString = wrongAns.toString();
		if (wrongQueIdString.endsWith(",")){
			wrongQueIdString = wrongQueIdString.substring(0, wrongQueIdString.length()-1);
			wrongAnsString = wrongAnsString.substring(0, wrongAnsString.length()-1);
		}
		p.setWrongQueId(wrongQueIdString);
		p.setWrongAns(wrongAnsString);
		Student s = (Student) request.getSession().getAttribute("user");
		p.setStudentId(s.getId());
		paperService.save(p);
		
		
		response.sendRedirect(request.getContextPath()+"/student/index.jsp");
		
	}

}
