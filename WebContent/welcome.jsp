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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>



</script>
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
	String email = (String)session1.getAttribute("authuser");
	String name = FetchData.getUserName(email);
	out.println("Welcome"+" "+name);
	
%>
<br>
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
<form action="logout" method="post">

<input type="submit" value ="logout" name="logout">

</form>
<%
}
%>


</body>
</html>