package servletPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;


import sun.text.normalizer.UTF16;

/**
 * Servlet implementation class Servlet
 */
@WebServlet(description = "This is a sample servlet", urlPatterns = { "/StudentServlet" })
public class StudentServlet extends HttpServlet implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;
	List<Student> students = new ArrayList<>();
	
	public StudentServlet() {
	this.students.add(new Student("aaa", 20));
	this.students.add(new Student("bbb", 50));
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Gson gson = new Gson();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		Json js = new Json(students, "hello from server");
		PrintWriter print = response.getWriter();
		String jsonprint = gson.toJson(js);
		print.print(jsonprint);
		print.flush();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Gson gson = new Gson();
				
		String name = request.getParameter("name");
		String getid = request.getParameter("id");
		int id = Integer.parseInt(getid);
		List<Student> list = new ArrayList<>(); 
		list = students.stream().filter(s->(s.getName().equalsIgnoreCase(name)) || (s.getId() == id)).collect(Collectors.toList());
		Json js = new Json(list, "hello from server");
		PrintWriter print = response.getWriter();
		String jsonprint = gson.toJson(js);
		print.print(jsonprint);
		print.flush();

		}
	

}
