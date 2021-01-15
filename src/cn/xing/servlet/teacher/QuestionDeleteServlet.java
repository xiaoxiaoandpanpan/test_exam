package cn.xing.servlet.teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xing.service.teacher.IQuestionService;
import cn.xing.service.teacher.QuestionService;

/**
 * Servlet implementation class QuestionDeleteServlet
 */
@WebServlet("/questionDeleteServlet")
public class QuestionDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IQuestionService questionService = new QuestionService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id");
		questionService.deleteQuestion(Integer.parseInt(id));
		response.sendRedirect(request.getContextPath()+"/questionQueryServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
