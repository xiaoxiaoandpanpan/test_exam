package cn.xing.servlet.teacher;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xing.po.Question;
import cn.xing.po.Teacher;
import cn.xing.service.teacher.IQuestionService;
import cn.xing.service.teacher.ITestService;
import cn.xing.service.teacher.QuestionService;
import cn.xing.service.teacher.TestService;

/**
 * Servlet implementation class TestDetailInfoSevlet
 */
@WebServlet("/testDetailInfoServlet")
public class TestDetailInfoSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ITestService testService =  new TestService(); 
	private IQuestionService questionService = new QuestionService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestDetailInfoSevlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Teacher teacher = (Teacher) request.getSession().getAttribute("user");
		String id=request.getParameter("id");
		Map<String, Object>test=testService.findTestsById(Integer.parseInt(id), teacher.getId());
		List<Question> questionList=questionService.findQuestionByIds(test.get("questions").toString());
		request.setAttribute("test", test);
		request.setAttribute("quesList", questionList); 
		request.getRequestDispatcher("/teacher/viewtest.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
