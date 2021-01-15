package cn.xing.servlet;

import java.io.IOException;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xing.po.StuClass;
import cn.xing.service.StuClassService;
import cn.xing.util.Department;

/**
 * Servlet implementation class StuClassAddServlet
 */
@WebServlet("/stuClassAddServlet")
public class StuClassAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static StuClassService stuClassService = new  StuClassService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuClassAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("depList", Department.values());
		request.getRequestDispatcher("/manager/stuclassadd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("clanum");
		String className = request.getParameter("claname");
		String depName = request.getParameter("depInfo");
		
		
		
		StuClass stuClass = new StuClass();
		stuClass.setId(Integer.parseInt(id));
		stuClass.setName(className);
		stuClass.setDeptName(depName);
		
		int resulit=stuClassService.addstuClass(stuClass);
		if (resulit==1) {
			response.sendRedirect(request.getContextPath()+"/stuClassQueryServlet");
		} else {
			response.sendRedirect(request.getContextPath()+"/stuClassAddServlet");			
		}
		
		
	}

}
