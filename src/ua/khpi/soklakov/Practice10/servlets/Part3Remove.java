package ua.khpi.soklakov.Practice10.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Part3Remove
 */
@WebServlet("/remove")
public class Part3Remove extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (!session.isNew()) {
			((List<String>) session.getAttribute("names")).clear();
		}

		RequestDispatcher disp = request.getRequestDispatcher("part3.jsp");
		disp.forward(request, response);
	}

}
