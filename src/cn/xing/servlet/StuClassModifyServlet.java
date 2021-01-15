package cn.xing.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xing.po.StuClass;
import cn.xing.service.IStuClassService;
import cn.xing.service.StuClassService;
import cn.xing.util.Department;


/**
 * Servlet implementation class StuClassModifyServlet
 */
@WebServlet("/stuClassModifyServlet")
public class StuClassModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static IStuClassService stuClassService = new StuClassService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuClassModifyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("info");
		System.out.println(id);
	    Map<String, Object>  stuClassMap =stuClassService.findStuClassById(Integer.parseInt(id));
	    request.setAttribute("stuClassMap", stuClassMap);
	    request.setAttribute("depList", Department.values());  
	    request.getRequestDispatcher("/manager/stuclassmodify.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("clanum");
		String name=request.getParameter("claname");
		String depName=request.getParameter("depInfo");
		
		StuClass stuClass = new StuClass();
		stuClass.setId(Integer.parseInt(id));
		stuClass.setName(name);
		stuClass.setDeptName(depName);
		
		stuClassService.updateStuClass(stuClass);
		
		response.sendRedirect(request.getContextPath()+"/stuClassQueryServlet");
		
	}

}
