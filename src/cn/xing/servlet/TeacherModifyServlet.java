package cn.xing.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xing.po.Teacher;
import cn.xing.service.TeacherService;
import cn.xing.util.Department;

/**
 * Servlet implementation class TeacherModifyServlet
 */
@WebServlet("/teacherModifyServlet")
public class TeacherModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherService teacherService= new TeacherService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id= request.getParameter("id");
		Map<String, Object>teacher= teacherService.findTeacherInfo(Integer.parseInt(id));
		request.setAttribute("teacherInfo", teacher);
		request.setAttribute("deptList", Department.values());
		request.getRequestDispatcher("/manager/teachermodify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Teacher teacher= new Teacher();
		teacher.setId(Integer.parseInt(request.getParameter("num")));
		teacher.setName(request.getParameter("username"));
		teacher.setPwd(request.getParameter("password"));
		teacher.setDeptName(request.getParameter("dep"));
		teacherService.updateTeacher(teacher, 0);
		response.sendRedirect(request.getContextPath()+"/teacherQueryServlet");
	}

}
