package cn.xing.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet Filter implementation class PowerFilter
 */
@WebFilter(filterName="/PowerFilter",urlPatterns={"/*"})
public class PowerFilter implements Filter {

    /**
     * Default constructor. 
     */
    public PowerFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		/*HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;*/
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse)response;
		Object getSs = req.getSession().getAttribute("user");
		String currentURL = req.getRequestURI();
		System.out.println("我是完整的URL："+currentURL+"?"+req.getQueryString());
		String targetURL= currentURL.substring(currentURL.indexOf("/",1),currentURL.length());
		System.out.println(targetURL);
		if (getSs==null&&!targetURL.equals("/login.jsp")&&!targetURL.equals("/")) {
			if(!targetURL.equals("/Login.do")){
				resp.sendRedirect("http://localhost:8080/HpTest");
				return;
				}
			//resp.sendRedirect("http://localhost:8080/HpTest");
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
