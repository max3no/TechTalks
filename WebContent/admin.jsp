<%@page import="com.atemcs.techtalks.FetchData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	String email = (String)session1.getAttribute("authadmin");
	String name = FetchData.getUserName(email);
	out.println("Welcome"+" "+name);
%>
<form action="logout" method="post">

<input type="submit" value ="logout" name="logout">

</form>
<%
}
%>
</body>
</html>