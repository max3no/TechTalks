<%@page import="com.atemcs.techtalks.techtalks"%>
<%@page import="com.atemcs.techtalks.users"%>
<%@page import="com.atemcs.techtalks.FetchData"%>
<%@page import="com.atemcs.techtalks.LogoutController"%>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>TechTalks</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>



<body>
<%
HttpSession session1 = request.getSession();
if(session1.getAttribute("authuser") == null)
{
	out.println("Login first");
	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	rd.include(request, response);
}
else
{
	
	
%>

<form action="logout" method="post">

<input type="submit" value ="logout" name="logout">

</form>






<div id="main_block">
  <div id="top_block"> 
  <a href="http://google.com"><img src="images/logo_crop.jpg" alt="" width="220" height="72" style="margin:50px 0 0 55px;" /></a> 
  <img src="images/main_at.jpg" alt="" width="380" height="233" style="margin:0 0 0 345px;" /> 
   
  <span class="navi2"> 
  
  </span> <span class="hd" style="margin:-35px 5px 15px 60px">TechTonics...
  <% String email = (String)session1.getAttribute("authuser");
	String name = FetchData.getUserName(email);
	out.println("Welcome"+" "+name); %></span> 
    
    
</div>
</div>
<div id="sub_block">

  <div id="content_block">
    <div id="center_block"><span class="titl" style="margin:0px 0px 15px 370px"  >Upcoming Talks</span>
    </div>
    <%
    ArrayList<techtalks> list = FetchData.getTalks();
	for(techtalks t:list)
	{
		out.println("<form action='attend' method='post'>");
		out.println(t.getPresenteeName());
		out.println(t.getTopic());
		out.println(t.getWhen());
		out.println(t.getLocation());
		out.println("<input type='submit' value='Attend - TT"+t.getTechtalksid()+"' name="+t.getTechtalksid()+">");
		out.println("<br>");
		out.println("</form>");
	}
    %>
      
       
       
   
  </div>
</div>
<div id="sub_block2">
  <div id="footer_block">
  
   <span class="lnk" style="margin:0 0 15px 250px;"> &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&copy;Copyright 2017. All rights reserved. <a href="http://www.atmecs.com" style="color:#ffffff;">Atmecs</a> designed by Vai</span> </div>
</div>
<%
}
%>
</body>
</html>
