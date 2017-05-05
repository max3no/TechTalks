package com.atemcs.techtalks;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

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
		System.out.println("here");
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
		if(attendCode == 1)
		{
			System.out.println("You are now attending");
		}
		else if(attendCode == 3)
		{
			System.out.println("Already attending");
		}
		else
		{
			System.out.println("Some error occured try again later or contact admin team");
		}
	}

}
