package cn.xing.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xing.po.StuClass;
import cn.xing.service.StuClassService;

/**
 * Servlet implementation class StuClassQueryServlet
 */
@WebServlet("/stuClassQueryServlet")
public class StuClassQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static StuClassService stuClassService = new StuClassService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuClassQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Map<String, Object>> stuList=stuClassService.findAll();
		//List stuClasseList= stuClassService.findAll();
		request.setAttribute("scList", stuList);
		request.getRequestDispatcher("/manager/stuclassmanage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
