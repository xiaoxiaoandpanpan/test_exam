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
 * Servlet implementation class StudentAddServlet
 */
@WebServlet("/studentAddServlet")
public class StudentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StuClassService stuClassService = new StuClassService();
    private StudentService studentService = new StudentService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String, Object>> stuClsss= stuClassService.findAll();
		request.setAttribute("classList", stuClsss);
		request.setAttribute("deptList", Department.values());
		
		request.getRequestDispatcher("/manager/studentadd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		Student student = new Student();
		student.setId(Integer.parseInt(request.getParameter("id")));
		student.setName(request.getParameter("name"));
		student.setBorn(request.getParameter("born"));
		student.setPwd(request.getParameter("pwd"));
		student.setSchool(request.getParameter("school"));
		student.setSex(request.getParameter("sex"));
		student.setDeptName(request.getParameter("deptName"));
		student.setClassId(Integer.parseInt(request.getParameter("classId")));
		System.out.println(student);
		Student relStudent=studentService.findStudentById(student.getId());
		if (relStudent!=null) {
			request.setAttribute("eeor", "该学号已存在，请检查是否填写正确！");
			request.getRequestDispatcher("/manager/result.jsp").forward(request, response);
			
		}else{
			studentService.addStudent(student);
			response.sendRedirect(request.getContextPath()+"/studentQueryServlet");
		}
		
		
	}

}
