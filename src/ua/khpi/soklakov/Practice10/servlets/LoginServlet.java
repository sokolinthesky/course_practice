package ua.khpi.soklakov.Practice10.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.khpi.soklakov.Practice10.db.UserDao;
import ua.khpi.soklakov.Practice10.db.UserDaoImpl;
import ua.khpi.soklakov.Practice10.entity.Role;
import ua.khpi.soklakov.Practice10.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("POST!!!!");
		HttpSession session = request.getSession();
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		UserDao userDao = new UserDaoImpl();

		if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
			response.getWriter().append("Login or password is empty.");
		} else {
			User user = userDao.findUserByLogin(login);

			if (user == null || !password.equals(user.getPassword())) {
				response.getWriter().append("Cannot find user with such login/password");
			} else {
				Role userRole = Role.getRole(user);
				
				session.setAttribute("user", user);
				session.setAttribute("userRole", userRole);
				
				response.sendRedirect("part3");
			}
		}
	}

}
