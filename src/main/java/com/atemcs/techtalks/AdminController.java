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
 * Servlet implementation class AdminController
 */
@WebServlet("/modify")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		String option = techId.substring(0,6);
		String id  = techId.substring(11);
		int idtech = Integer.parseInt(id);
		PrintWriter ps = response.getWriter();
		if(option.equals("Delete"))
		{
			int res = FetchData.deleteTalk(idtech);
			if(res == 1)
			{
				ps.println("<script type=\"text/javascript\">");
				ps.println("alert('Talk Deleted!!!');");
				ps.println("location='admin.jsp';");
				ps.println("</script>");
				RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
				rd.include(request, response);
			}
			else
			{
				ps.println("<script type=\"text/javascript\">");
				ps.println("alert('Some error occured!!!');");
				ps.println("location='admin.jsp';");
				ps.println("</script>");
				RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
				rd.include(request, response);
			}
		}
		else
		{
			
			
		}
	
	}

}
