package cn.xing.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xing.po.Course;
import cn.xing.service.CourseService;

/**
 * Servlet implementation class CourseModifyServlet
 */
@WebServlet("/courseModifyServlet")
public class CourseModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CourseService courseService = new CourseService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("info");
		Course course=courseService.findCourseById(Integer.parseInt(id));
		request.setAttribute("course", course);
		request.getRequestDispatcher("/manager/coursemodify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Course course =new Course();
		course.setId(Integer.parseInt(request.getParameter("id")));
		course.setName(request.getParameter("courname"));
		
		courseService.updateCourse(course);
		response.sendRedirect(request.getContextPath()+"/courseQueryServlet");
	}

}
