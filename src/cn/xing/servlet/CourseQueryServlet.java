package cn.xing.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.SetCharacterEncodingFilter;

import cn.xing.po.Course;
import cn.xing.service.CourseService;

/**
 * Servlet implementation class CourseQueryServlet
 */
@WebServlet("/courseQueryServlet")
public class CourseQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CourseService courseService = new CourseService();
        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		List<Course> listCourse =courseService.findAllCourses();
		
		request.setAttribute("tcList", listCourse);
		request.getRequestDispatcher("/manager/coursemanage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String courseSearch= request.getParameter("courseSearch");
		List<Course> courseList=courseService.findAllCourses(courseSearch);
		request.setAttribute("tcList", courseList);
		request.setAttribute("courseSearch", courseSearch);
		request.getRequestDispatcher("/manager/coursemanage.jsp").forward(request, response);
		
	}

}
