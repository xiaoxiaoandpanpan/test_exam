package cn.xing.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xing.service.CourseService;
import cn.xing.vo.TeacherCourseView;

/**
 * Servlet implementation class ScheduleQueryServlet
 */
@WebServlet("/scheduleQueryServlet")
public class ScheduleQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CourseService courseService = new CourseService();
       
    public ScheduleQueryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List<TeacherCourseView> teacherCourseViews=courseService.findAll();
		 request.setAttribute("tcList",teacherCourseViews );
		 request.getRequestDispatcher("/manager/schedulemanage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search= request.getParameter("courseSearch");
		
		List<TeacherCourseView> teacherCourseViews=courseService.findTeacherCourseByKey(search);
		request.setAttribute("tcList",teacherCourseViews );
		request.setAttribute("courseSearch", search);
		 request.getRequestDispatcher("/manager/schedulemanage.jsp").forward(request, response);
	}

}
