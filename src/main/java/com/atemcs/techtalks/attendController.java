package com.atemcs.techtalks;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class attendController
 */
@WebServlet("/attend")
public class attendController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public attendController() {
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
		List<String> params = Collections.list(request.getParameterNames());//Get param name
		String techId=null;
		for (String p: params)
		{
		  techId=request.getParameter(p);// get param value for each param
		}
		String techIdConcat=techId.substring(11);
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("authuser");
		int empId = FetchData.getUserId(email);
		int techTalkId = Integer.parseInt(techIdConcat);
		System.out.println(empId+" "+techTalkId);
		int attendCode = FetchData.attendTalk(empId, techTalkId);
		PrintWriter ps = response.getWriter();
		if(attendCode == 1)
		{
			ps.println("<script type=\"text/javascript\">");
			  ps.println("alert('You are attending now!!!');");
			   ps.println("location='welcome.jsp';");
			   ps.println("</script>");
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
			rd.include(request, response);
	
		
		}
		else if(attendCode == 3)
		{
			ps.println("<script type=\"text/javascript\">");
			  ps.println("alert('You are already attending this!!!');");
			   ps.println("location='welcome.jsp';");
			   ps.println("</script>");
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
			rd.include(request, response);
		}
		else
		{

			ps.println("<script type=\"text/javascript\">");
			  ps.println("alert('Some error occured please try again later!!!');");
			   ps.println("location='welcome.jsp';");
			   ps.println("</script>");
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
			rd.include(request, response);
		}
	}

}
