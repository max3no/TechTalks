package com.atemcs.techtalks;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signupController
 */
@WebServlet("/signup")
public class signupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signupController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String emp = request.getParameter("empid");
		int empid = Integer.parseInt(emp);
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		int sign = FetchData.Signup(empid, name, password, email);
		PrintWriter ps = response.getWriter();
		if(sign == 1)
		{
			ps.println("<script type=\"text/javascript\">");
			  ps.println("alert('Successfully Signed In!!!');");
			   ps.println("location='index.jsp';");
			   ps.println("</script>");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
			
		}
		else if(sign == 3)
		{
			ps.println("<script type=\"text/javascript\">");
			  ps.println("alert('User with same Employee ID Already Exists!!!');");
			   ps.println("location='signup.jsp';");
			   ps.println("</script>");
			RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
			rd.include(request, response);
		}
		else
		{
			ps.println("<script type=\"text/javascript\">");
			  ps.println("alert('Some error occured please try again later!!!');");
			   ps.println("location='signup.jsp';");
			   ps.println("</script>");
			RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
			rd.include(request, response);
			
		}
	}

}
