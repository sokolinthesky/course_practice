package ua.khpi.soklakov.Practice10.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ua.khpi.soklakov.Practice10.entity.Role;


/**
 * Servlet Filter implementation class AccessFilter
 */
@WebFilter("/AccessFilter")
public class AccessFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AccessFilter() {
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
		if(accessAllowed(request)) {
			chain.doFilter(request, response);
		} else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	
	private boolean accessAllowed(ServletRequest request) {
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		HttpSession session = httpRequest.getSession(false);
		if (session == null)
			return false;
		Role userRole = (Role) session.getAttribute("userRole");
		if (userRole == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
