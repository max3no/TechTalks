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
 * Servlet implementation class updateController
 */
@WebServlet("/update")
public class updateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateController() {
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
		
		String presenteename = request.getParameter("presenteename");
		String topic = request.getParameter("topic");
		String location = request.getParameter("location");
		HttpSession ses = request.getSession();
		String id = (String)ses.getAttribute("updateid");
		String when = request.getParameter("when");
		//String id = (String)request.getAttribute("updateid");
		System.out.println(id);
		int upId = Integer.parseInt(id);
		int update = FetchData.UpdateTech(upId, presenteename, topic, location, when);
		PrintWriter ps = response.getWriter();
		if(update == 1)
		{
			ps.println("<script type=\"text/javascript\">");
			ps.println("alert('Talk Updated');");
			ps.println("location='admin.jsp';");
			ps.println("</script>");
			RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
			rd.include(request, response);
		}
		else
		{
			ps.println("<script type=\"text/javascript\">");
			ps.println("alert('Some error occured please try later...!!!');");
			ps.println("location='admin.jsp';");
			ps.println("</script>");
			RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
			rd.include(request, response);
		}
		
		
	
	}

}
