package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Actor;
import beans.Customer;
import connector.JDBCExample;

/**
 * Servlet implementation class Facebook
 */
@WebServlet("/Facebook")
public class Facebook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Facebook() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//PrintWriter writer = response.getWriter();
		// writer.append("Facebook\n Home page\tProfile");
		String name=request.getParameter("first_name");

		List<Actor> liOfActors = JDBCExample.getActorsDataFromDb( name);
		
		// writer.append(rs);

		request.setAttribute("result", liOfActors);
		request.getRequestDispatcher("actors.jsp").forward(request, response);
		request.getRequestDispatcher("customerresult.jsp").forward(request, response);

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
