package cn.xing.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xing.po.Student;
import cn.xing.service.StuClassService;
import cn.xing.service.StudentService;
import cn.xing.util.Department;

/**
 * Servlet implementation class StudentModifyServlet
 */
@WebServlet("/studentModifyServlet")
public class StudentModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService studentService=  new StudentService();
	private StuClassService stuClassService = new  StuClassService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		Student student=studentService.findStudentById(Integer.parseInt(id));
		request.setAttribute("student", student);
		request.setAttribute("deptList", Department.values());
		List<Map<String, Object>> stuClsss= stuClassService.findAll();
		request.setAttribute("classList", stuClsss);
		request.getRequestDispatcher("/manager/studentmodify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Student student = new Student();
		student.setId(Integer.parseInt(request.getParameter("id")));
		student.setName(request.getParameter("name"));
		student.setPwd(request.getParameter("pwd"));
		student.setSchool(request.getParameter("school"));
		student.setSex(request.getParameter("sex"));
		student.setBorn(request.getParameter("born"));
		student.setClassId(Integer.parseInt(request.getParameter("classId")));
		student.setDeptName(request.getParameter("deptId"));
		studentService.updateStudent(student);
		response.sendRedirect(request.getContextPath()+"/studentQueryServlet");
		
	}

}
