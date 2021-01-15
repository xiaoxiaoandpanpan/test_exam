package cn.xing.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xing.po.Student;
import cn.xing.po.Teacher;
import cn.xing.service.ILoginService;
import cn.xing.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ILoginService loginService = new LoginService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		String role = request.getParameter("role");
		
		/*response.getWriter().append("username:").append(name).append("</br>");
		response.getWriter().append("password:").append(password);*/
		if ("admin".equals(role)) {
			if("xing".equals(name)&&"123".equals(password)){		
				request.getSession().setAttribute("user", name);
				request.getRequestDispatcher("/manager/mindex.jsp").forward(request, response);
			}else {
				response.sendRedirect("http://localhost:8080/HpTest/login.jsp");
			}
		} else if("teacher".equals(role)){
			Teacher teacher=new Teacher();
			Teacher t=new Teacher();
			t.setName(name);
			t.setPwd(password);
			teacher = loginService.canLogin(t);
			if (teacher!=null) {
				request.getSession().setAttribute("user", teacher);
				request.getRequestDispatcher("/teacher/tindex.jsp").forward(request, response);
			} else {
				response.sendRedirect("http://localhost:8080/HpTest");
			}
		}else if("student".equals(role)){
			Student student= new Student();
			System.out.println(student);
			student=null;
			Student s = new Student();
			s.setName(name);
			s.setPwd(password);
			student=loginService.canLogin(s);
			if(student!=null) {
				request.getSession().setAttribute("user", student);
				request.getRequestDispatcher("/student/index.jsp").forward(request, response);
			}else {
				response.sendRedirect("http://localhost:8080/HpTest");
			}
		}else {
			response.sendRedirect("http://localhost:8080/HpTest");
		}
		
	/*	response.sendRedirect("/WEB-INF/jsp/index.jsp");*/
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
