package ua.khpi.soklakov.Practice9.servlets;

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

import ua.khpi.soklakov.Practice9.*;

/**
 * Servlet implementation class VouteServlet
 */
@WebServlet("/voutes")
public class VouteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static List<KindOfSport> kindsOfSport = new ArrayList<>();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (kindsOfSport.isEmpty()) {
			String[] aSports = getServletContext().getInitParameter("list").split(" ");
			for (String sportName : aSports) {
				kindsOfSport.add(new KindOfSport(sportName));
			}
		}

		request.setAttribute("list", kindsOfSport);

		RequestDispatcher disp = request.getRequestDispatcher("WEB-INF/jsp/welcome.jsp");
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
		String sport = request.getParameter("sport");
		
		if (session.isNew()) {
			for (KindOfSport kos : kindsOfSport) {
				if (kos.getName().equals(sport)) {
					kos.getVoutedName().add(name);
					session.setAttribute("name", name);
					session.setAttribute("nameList", new ArrayList<String>());

					((List<String>) session.getAttribute("nameList")).add(name);

					request.setAttribute("list", kindsOfSport);

					RequestDispatcher disp = request.getRequestDispatcher("WEB-INF/jsp/vouteResult.jsp");
					disp.forward(request, response);

				}
			}
		} else {
			if (((List<String>) session.getAttribute("nameList")).contains(name)) {
				response.getWriter().append("You have vouted already. <a href=\"/Practice9\">Back</a>");
			} else {

				for (KindOfSport kos : kindsOfSport) {
					if (kos.getName().equals(sport)) {
						kos.getVoutedName().add(name);
						session.setAttribute("name", name);

						request.setAttribute("list", kindsOfSport);

						RequestDispatcher disp = request.getRequestDispatcher("WEB-INF/jsp/vouteResult.jsp");
						disp.forward(request, response);
					}
				}
			}

		}
	}

}
