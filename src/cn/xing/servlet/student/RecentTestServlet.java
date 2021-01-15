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
import cn.xing.service.teacher.ITestService;
import cn.xing.service.teacher.PapersService;
import cn.xing.service.teacher.TestService;
import cn.xing.util.ToolUtil;

/**
 * Servlet implementation class StudentPaperServlet
 */
@WebServlet("/recentTestServlet")
public class RecentTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IPaperService paperService = new PapersService();
	//private ITestService testService = new TestService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecentTestServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student=(Student) request.getSession().getAttribute("user");
		List<Map<String, Object>> testList=paperService.getPaperByStudentId(student.getId(),ToolUtil.getCurrentTime());
		//List<Map<String, Object>> testList=testService.getTestByStudent(student.getId(), ToolUtil.getCurrentTime());
		request.setAttribute("testList", testList);
		request.getRequestDispatcher("/student/main.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
