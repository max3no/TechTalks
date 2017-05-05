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

/**
 * Servlet implementation class RequestedController
 */
@WebServlet("/Requested")
public class RequestedController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestedController() {
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
		String actionToPerform=null;
		for (String p: params)
		{
		  actionToPerform=request.getParameter(p);// get param value for each param
		}
		String action = actionToPerform.substring(0, 7);
		String id=actionToPerform.substring(12);
		System.out.println(action);
		System.out.println(id);
		int reqid=Integer.parseInt(id);
		PrintWriter ps = response.getWriter();
		if(action.equals("Approve"))
		{
			int result  = FetchData.ApproveRequestedTalks(reqid);
			if(result == 1)
			{
				ps.println("<script type=\"text/javascript\">");
				  ps.println("alert('Request Approved');");
				   ps.println("location='requested.jsp';");
				   ps.println("</script>");
				RequestDispatcher rd = request.getRequestDispatcher("requested.jsp");
				rd.include(request, response);
			}
			else if(result == 2)
			{
				ps.println("<script type=\"text/javascript\">");
				  ps.println("alert('Error occured on server!!!');");
				   ps.println("location='requested.jsp';");
				   ps.println("</script>");
				RequestDispatcher rd = request.getRequestDispatcher("requested.jsp");
				rd.include(request, response);
			}
			else
			{
				ps.println("<script type=\"text/javascript\">");
				  ps.println("alert('Unable to approve request !!!');");
				   ps.println("location='requested.jsp';");
				   ps.println("</script>");
				RequestDispatcher rd = request.getRequestDispatcher("requested.jsp");
				rd.include(request, response);
			}
		}
		else
		{
			
		}
	}

}
