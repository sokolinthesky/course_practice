package ua.khpi.soklakov.Practice10.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.khpi.soklakov.Practice10.db.UserDao;
import ua.khpi.soklakov.Practice10.db.UserDaoImpl;
import ua.khpi.soklakov.Practice10.entity.User;

/**
 * Servlet implementation class Part4Servlet
 */
@WebServlet("/part4")
public class Part4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher("part4.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String newName = request.getParameter("name");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		int roleId = Integer.parseInt(request.getParameter("roleId"));
		UserDao userDao = new UserDaoImpl();
		User user = new User(id, newName, login, password, roleId);
		
		userDao.editUser(user);
		request.getSession().setAttribute("user", user);
		
		
		response.sendRedirect("part3");
	}

}
