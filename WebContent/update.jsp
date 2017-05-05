
<%@page import="com.atemcs.techtalks.techtalks"%>
<%@page import="com.atemcs.techtalks.users"%>
<%@page import="com.atemcs.techtalks.FetchData"%>
<%@page import="com.atemcs.techtalks.LogoutController"%>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <title>Atmecs TechTalks</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <link rel="stylesheet" type="text/css" href="style/style.css" title="style" />
</head>

<body>

<%
HttpSession session1 = request.getSession();
if(session1.getAttribute("authadmin") == null)
{
	out.println("Login first");
	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	rd.include(request, response);
}
else
{
	
	
%>


  <div id="main">
    <div id="header">
      <div id="logo">
        <div id="logo_text">
          <!-- class="logo_colour", allows you to change the colour of the text -->
          <h1><a href="#">ATMECS<span class="logo_colour">...</span></a></h1>
          <h2>Passionate minds.</h2>	
        </div>
      </div>
      <div id="menubar">
        <ul id="menu">
          <!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
          <li class="selected">
          <a href="<%=request.getContextPath()%>/admin.jsp">Home</a></li>
          <li><a href="<%=request.getContextPath()%>/request.jsp">Requested TechTalks</a></li>
          <li><a href="another_page.html">Setting</a></li>
          <li><a href="<%=request.getContextPath()%>/logout">Logout</a></li>
        </ul>
      </div>
    </div>
    <div id="site_content">
    <form action="update" method="post">
    <%
    ArrayList<techtalks> list = (ArrayList<techtalks>)request.getAttribute("data");
    %>
    <table style="margin: 0 auto;width:250px"><tr>
    <th>Presentee</th>
    <th>Topic</th>
    <th>Location</th>
    <th>When</th></tr>
    <%
        		  
    for(techtalks t:list)
    {
    	%>
    	<tr>
    	<td>
    	<input type="text" name="presenteename" value="<%out.print(t.getPresenteeName());%>"></td>
    	
    	<td>
		<textarea rows="4" cols="50" name="topic" required><%out.print(t.getTopic()); %></textarea>
		</td>
    	
    	<td>
    	<select name="location">
  		<option value="American Eagle">American Eagle</option>
  		<option value="Training Room">Training Room</option>
  		<option value="Conference Room">Conference Room</option>
  		
		</select>
    	</td>
    	<td>
       	<input type="date" name="when" value="<%out.print(t.getWhen());%>"></td></tr>
    <%
    }
    %>
    <tr>
    <td colspan="4">
    <input type="submit" name="update" value="Update">
    </td>
    </tr>
    </table>
    
	      </form>     
      </div>
      
    </div>
    <div id="footer">
      Copyright &copy; Copyright 2017. All rights reserved | <a href="http://www.atmecs.com">Atmecs</a> | Designed by Vai
    </div>
  </div>
  
  <%
}
%>
  
</body>
</html>
