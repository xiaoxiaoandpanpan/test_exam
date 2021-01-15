package cn.xing.servlet.teacher;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xing.po.Teacher;
import cn.xing.service.teacher.ITestService;
import cn.xing.service.teacher.TestService;


/**
 * Servlet implementation class TestQueryServlet
 */
@WebServlet("/testQueryServlet")
public class TestQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ITestService testService = new TestService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestQueryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Teacher teacher =(Teacher) request.getSession().getAttribute("user");
		List<Map<String , Object>> testlist = testService.findTestsByTeaId(teacher.getId());
		request.setAttribute("testsList", testlist);
		request.getRequestDispatcher("/teacher/tmain.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath()+"/testQueryServlet");
	}

}
