package servletPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet2 implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	List<String> list = new ArrayList<>();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get");
		request.getSession().setAttribute("connector", list);
		if(!(null == request.getParameter("deleted"))) {
			list.remove(Integer.valueOf(request.getParameter("deleted")) - 1);
			System.out.println("deleted");
		}
		request.getRequestDispatcher("/student.jsp").forward(request, response);
		System.out.println("get succeeded");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post");
		String name = request.getParameter("name").toString();
		list.add(name);
		request.getSession().setAttribute("connector", list);
		request.getRequestDispatcher("/student.jsp").forward(request, response);
		System.out.println("post succeeded");
	}


	

}
