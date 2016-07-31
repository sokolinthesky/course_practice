package ua.khpi.soklakov.Practice10.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Part3Servlet
 */
@WebServlet("/part3")
public class Part3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (session.isNew() || session.getAttribute("names") == null) {
			System.out.println("new!");
			session.setAttribute("names", new ArrayList<String>());
		}

		request.setAttribute("names", session.getAttribute("names"));

		RequestDispatcher disp = request.getRequestDispatcher("part3.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String name = request.getParameter("name");

		((List<String>) session.getAttribute("names")).add(name);

		response.sendRedirect("part3");
	}

}
