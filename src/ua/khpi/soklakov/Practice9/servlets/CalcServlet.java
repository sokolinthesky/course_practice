package ua.khpi.soklakov.Practice9.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.khpi.soklakov.Practice9.Calculator;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int res = Calculator.calc(Integer.parseInt(request.getParameter("x")),
					Integer.parseInt(request.getParameter("y")), request.getParameter("op"));

			request.setAttribute("result", res);

			RequestDispatcher disp = request.getRequestDispatcher("WEB-INF/jsp/calcResult.jsp");
			disp.forward(request, response);
		} catch (NumberFormatException ex) {
			response.setContentType("text/html");
			response.getWriter().append("Incorrect x or y. <a href=\"/Practice9\">Back</a>");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
