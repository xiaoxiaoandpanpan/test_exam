package cn.xing.servlet.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xing.po.Teacher;
import cn.xing.service.teacher.IPaperService;
import cn.xing.service.teacher.PapersService;

/**
 * Servlet implementation class PapersCompareServlet
 */
@WebServlet("/papersCompareServlet")
public class PapersCompareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IPaperService paperService = new PapersService();
       
   
    public PapersCompareServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Teacher teacher = (Teacher) request.getSession().getAttribute("user");
		List paperList= paperService.getPaperCompare(teacher.getId());
		request.setAttribute("paperList", paperList);
		request.getRequestDispatcher("/teacher/classpapers.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
