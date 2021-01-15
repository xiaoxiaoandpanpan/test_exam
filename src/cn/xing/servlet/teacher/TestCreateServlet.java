package cn.xing.servlet.teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xing.po.Test;
import cn.xing.service.teacher.ITestService;
import cn.xing.service.teacher.TestService;

/**
 * Servlet implementation class TestCreateServlet
 */
@WebServlet("/testCreateServlet")
public class TestCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ITestService testService =new TestService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestCreateServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Test test=(Test) request.getSession().getAttribute("test");
		testService.createTest(test);
		request.getSession().removeAttribute("test");
		response.sendRedirect(request.getContextPath()+"/testQueryServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
