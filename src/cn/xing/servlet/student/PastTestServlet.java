package cn.xing.servlet.student;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xing.po.Student;
import cn.xing.service.teacher.IPaperService;
import cn.xing.service.teacher.PapersService;

/**
 * Servlet implementation class PastTestServlet
 */
@WebServlet("/pastTestServlet")
public class PastTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IPaperService paperService= new PapersService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PastTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student s = (Student)request.getSession().getAttribute("user");
		List<Map<String, Object>> pastPaperList = paperService.getPaperByStudentId(s.getId());
		request.setAttribute("paperList", pastPaperList);
		request.getRequestDispatcher("/student/history.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
