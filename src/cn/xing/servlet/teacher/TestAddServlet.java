package cn.xing.servlet.teacher;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.xmlrpc.base.Data;

import cn.xing.po.Course;
import cn.xing.po.StuClass;
import cn.xing.po.Teacher;
import cn.xing.po.Test;
import cn.xing.service.CourseService;
import cn.xing.service.ICourseService;
import cn.xing.service.IStuClassService;
import cn.xing.service.StuClassService;
import cn.xing.service.teacher.IQuestionService;
import cn.xing.service.teacher.QuestionService;
import cn.xing.util.ToolUtil;

/**
 * Servlet implementation class TestAddServlet
 */
@WebServlet("/testAddServlet")
public class TestAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICourseService courseService = new CourseService();
	private IStuClassService stuClassService = new StuClassService();
    private IQuestionService questionService = new QuestionService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Teacher teacher= (Teacher) request.getSession().getAttribute("user");
		List<Course>courses=courseService.findCourseByTeacherId(teacher.getId());
		List<StuClass> stuClasses=stuClassService.findClassByTeacherId(teacher.getId());
		request.setAttribute("courseList",courses );
		request.setAttribute("classesList",stuClasses );
		request.getRequestDispatcher("/teacher/testadd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Teacher teacher = (Teacher) request.getSession().getAttribute("user");
			
		String courseId=request.getParameter("courseid");
		String testName=request.getParameter("testname");
		String endDate = request.getParameter("enddate");
		String score = request.getParameter("sinscores");
		String queNum= request.getParameter("sinnum");
		String testTime= request.getParameter("testtime");
		
		String[] classIds = request.getParameterValues("classCheck");
		//查找科目
		Course course=courseService.findCourseById(Integer.parseInt(courseId));
		//查找面向班级名称
		String classNames = stuClassService.findClassNamesByIds(ToolUtil.arraytoString(classIds));
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		try {
			date=format.parse(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取试题
		List<Map<String , Object>>lists=questionService.collectQuestions(Integer.parseInt(courseId), Integer.parseInt(queNum));
		Test test = new Test();
		test.setName(testName);
		test.setCourseId(course.getId());
		test.setEndDate(date);
		test.setScores(score);
		test.setTeacherId(teacher.getId());
		test.setTestTime(Integer.parseInt(testTime));
		test.setClassIds(ToolUtil.arraytoString(classIds));
		test.setQuetions(questionService.testQuestionIds(lists));
		
		request.setAttribute("c", course);
		request.getSession().setAttribute("test", test);
		request.setAttribute("classNames", classNames);
		request.setAttribute("quesList",lists );
		request.getRequestDispatcher("/teacher/test.jsp").forward(request, response);
	}

}
