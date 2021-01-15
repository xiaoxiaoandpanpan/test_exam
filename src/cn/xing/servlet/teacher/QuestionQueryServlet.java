package cn.xing.servlet.teacher;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xing.service.teacher.IQuestionService;
import cn.xing.service.teacher.QuestionService;

/**
 * Servlet implementation class Questionmanage
 */
@WebServlet("/questionQueryServlet")
public class QuestionQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IQuestionService questionService = new QuestionService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  key = request.getParameter("selectk");
		String value = request.getParameter("quesname");
		System.out.println(key+"->"+value);
		List<Map<String , Object>> lists= questionService.findAll(key, value);
		request.setAttribute("queList", lists);
		request.setAttribute("value", value);
		request.getRequestDispatcher("teacher/questionmanage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
