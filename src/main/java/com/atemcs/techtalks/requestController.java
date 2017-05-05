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
 * Servlet implementation class requestController
 */
@WebServlet("/request")
public class requestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public requestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String topic = request.getParameter("topic");
		String location = request.getParameter("location");
		
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("authuser");
		int empid = FetchData.getUserId(email);
		String empname = FetchData.getUserName(email);
		
		int reqTalk = RequestTalk.makeRequest(empid,empname,topic,location);
		PrintWriter ps  = response.getWriter();
		if(reqTalk == 1)
		{
			ps.println("<script type=\"text/javascript\">");
			  ps.println("alert('Successfully Requested');");
			   ps.println("location='request.jsp';");
			   ps.println("</script>");
			RequestDispatcher rd = request.getRequestDispatcher("request.jsp");
			rd.include(request, response);
		}
		else
		{

			ps.println("<script type=\"text/javascript\">");
			  ps.println("alert('Some error occured please try again later!!!');");
			   ps.println("location='request.jsp';");
			   ps.println("</script>");
			RequestDispatcher rd = request.getRequestDispatcher("request.jsp");
			rd.include(request, response);
		}
		
	}

}
