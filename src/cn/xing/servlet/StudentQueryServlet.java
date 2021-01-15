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
import cn.xing.service.StudentService;

/**
 * Servlet implementation class StudentQueryServlet
 */
@WebServlet("/studentQueryServlet")
public class StudentQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService studentService=new StudentService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		List<Map<String, Object>> studens=studentService.findAll();
		request.setAttribute("studentList", studens);
		request.getRequestDispatcher("/manager/studentmanage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		List<Student> students= studentService.studentList(name);
		request.setAttribute("studentList", students);
		request.setAttribute("searchname", name);
		request.getRequestDispatcher("/manager/studentmanage.jsp").forward(request, response);
	
	}

}
