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
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out  = response.getWriter();
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		String priv = request.getParameter("priv");
		boolean valid = LoginValidation.validate(email,pass,priv);
		System.out.println(priv);
		
		
			if(valid)
			{
				if(priv.equals("admin"))
				{
					HttpSession session = request.getSession();
					session.setAttribute("authadmin", email);
					
					//Connection con = SqlConnect.getSqlConnection();
					
					RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
					rd.include(request, response);	
				}
				else
				{
					HttpSession session = request.getSession();
					session.setAttribute("authuser", email);
					RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
					rd.include(request, response);
				}
				
			}
			else
			{
				out.println("Wrong Email or Password");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
			}
			
			
		}
		
		
	}


