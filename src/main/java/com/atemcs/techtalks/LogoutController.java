package com.atemcs.techtalks;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
		  out.println("alert('Logged out');");
		   out.println("location='index.jsp';");
		   out.println("</script>");
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.include(request, response);	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		
//		HttpSession session = request.getSession();
//		session.invalidate();
//		PrintWriter out = response.getWriter();
//
//		out.println("<script type=\"text/javascript\">");
//		  out.println("alert('Logged out');");
//		   out.println("location='index.jsp';");
//		   out.println("</script>");
//		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//		rd.include(request, response);	
	}
	

}
