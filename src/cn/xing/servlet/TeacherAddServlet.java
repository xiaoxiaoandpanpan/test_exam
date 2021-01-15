package cn.xing.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xing.po.Teacher;
import cn.xing.service.TeacherService;
import cn.xing.util.DBUtil;
import cn.xing.util.Department;

/**
 * Servlet implementation class TeacherAddServlet
 */
@WebServlet("/teacherAddServlet")
public class TeacherAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherService teacherService = new TeacherService();
        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("deptList", Department.values());
		request.getRequestDispatcher("/manager/teacheradd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		Teacher teacher =new Teacher();
		teacher.setId( Integer.parseInt(request.getParameter("num")));
		teacher.setName(request.getParameter("username"));
		teacher.setPwd(request.getParameter("password"));
		teacher.setDeptName(request.getParameter("dep"));
		Map<String , Object> result = teacherService.findTeacherInfo(teacher.getId());
		/*for (String  key : result.keySet()) {
			System.out.println("key:"+key+"->values:"+result.get(key));
		}*/
		if (result==null) {
			teacherService.addTeacher(teacher);
			response.sendRedirect(request.getContextPath()+"/teacherQueryServlet");
			
		} else {
			request.setAttribute("eeor", "该教师编号已存在，请检查是否填写正确！");
			request.getRequestDispatcher("/manager/result.jsp").forward(request, response);
		}
		//
		/*PrintWriter writer = response.getWriter();
		writer.println("GET " + request.getRequestURL() + " "
				+ request.getQueryString());
		
		Map<String, String[]> params = request.getParameterMap();
		for (String key : params.keySet()) {
			System.out.println("key:"+key+"->values:"+params.get(key)[0].toString());
		}*/
	/*	String queryString = "";
		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				
				String value = values[i];
				
				queryString += key + "=" + value + "&";
			}
		}
		queryString = queryString.substring(0, queryString.length() - 1);  
        writer.println("GET " + request.getRequestURL() + " " + queryString);  */
		
	}

}
