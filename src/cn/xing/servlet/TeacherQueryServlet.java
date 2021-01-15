package cn.xing.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xing.po.Teacher;
import cn.xing.service.ITeacherService;
import cn.xing.service.TeacherService;

/**
 * Servlet implementation class TeacherQueryServlet
 */
@WebServlet("/teacherQueryServlet")
public class TeacherQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private static ITeacherService teacherService =  new TeacherService();
    public TeacherQueryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		List<Map<String, Object>> teachers= teacherService.findAll();
		/*for (Map<String, Object> map : teachers) {
			 System.out.println(map.get("id"));
		}*/
		request.setAttribute("teacherList", teachers);
		request.getRequestDispatcher("/manager/teachermanage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		List<Teacher> teachers=teacherService.teacherList(name);
		request.setAttribute("name", name);
		request.setAttribute("teacherList", teachers);
		request.getRequestDispatcher("/manager/teachermanage.jsp").forward(request, response);
	}

}
