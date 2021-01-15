package cn.xing.servlet.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xing.po.Course;
import cn.xing.po.Question;
import cn.xing.service.CourseService;
import cn.xing.service.ICourseService;
import cn.xing.service.teacher.IQuestionService;
import cn.xing.service.teacher.QuestionService;

/**
 * Servlet implementation class QuestionAddServlet
 */
@WebServlet("/questionAddServlet")
public class QuestionAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IQuestionService questionService = new QuestionService();
	private ICourseService courseService = new CourseService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Course> courseList= courseService.findAllCourses();
		request.setAttribute("courseList", courseList);
		request.getRequestDispatcher("/teacher/quesadd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Question question = new Question();
		question.setCourseId(Integer.parseInt(request.getParameter("courseId")));
		question.setQueType(Integer.parseInt(request.getParameter("queType")));
		question.setQueTitle(request.getParameter("queTitle"));
		question.setChoiceA(request.getParameter("choiceA"));
		question.setChoiceB(request.getParameter("choiceB"));
		question.setChoiceC(request.getParameter("choiceC"));
		question.setChoiceD(request.getParameter("choiceD"));
		question.setAns(request.getParameter("ans"));
		questionService.addQuestion(question);
		response.sendRedirect(request.getContextPath()+"/questionQueryServlet");
		//questionService.findQuestionById(id);
	}

}
