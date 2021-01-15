package cn.xing.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xing.po.Course;
import cn.xing.po.TeacherCourse;
import cn.xing.service.CourseService;
import cn.xing.service.ICourseService;
import cn.xing.service.IStuClassService;
import cn.xing.service.ITeacherService;
import cn.xing.service.StuClassService;
import cn.xing.service.TeacherService;

/**
 * Servlet implementation class ScheduleAddServlet
 */
@WebServlet("/scheduleAddServlet")
public class ScheduleAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICourseService courseService = new CourseService();
	private ITeacherService teacherService= new TeacherService();
	private IStuClassService stuClassService = new StuClassService();
       
    public ScheduleAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Course>courses= courseService.findAllCourses();
		List<Map<String, Object>> stuclass=stuClassService.findAll();
		List<Map<String, Object>>teachers=teacherService.findAll();
		request.setAttribute("courseList", courses);
		request.setAttribute("stuclList", stuclass);
		request.setAttribute("teaList", teachers);
		request.getRequestDispatcher("/manager/scheduleadd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeacherCourse teacherCourse = new TeacherCourse();
		teacherCourse.setCourseId(Integer.parseInt(request.getParameter("course")));
		teacherCourse.setTeaId(Integer.parseInt(request.getParameter("teacher")));
		teacherCourse.setClassId(Integer.parseInt(request.getParameter("stuclass")));
		boolean result=courseService.modifyTeacherCourse(teacherCourse);
		if (result) {
			response.sendRedirect(request.getContextPath()+"/scheduleQueryServlet");	
		} else {
			request.setAttribute("eeor", "该教师已有所教课程，请核查输入！");
			request.getRequestDispatcher("/manager/result.jsp").forward(request, response);
		}
		
		
	}

}
