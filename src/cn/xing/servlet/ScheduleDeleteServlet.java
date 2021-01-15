package cn.xing.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xing.service.CourseService;
import cn.xing.service.ICourseService;

/**
 * Servlet implementation class ScheduleDeleteServlet
 */
@WebServlet("/scheduleDeleteServlet")
public class ScheduleDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ICourseService courseService = new CourseService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("info");
		courseService.deleteTeacherCourse(Integer.parseInt(id));
		response.sendRedirect(request.getContextPath()+"/scheduleQueryServlet");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
