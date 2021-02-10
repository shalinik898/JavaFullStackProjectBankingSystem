<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="com.model.Temporary"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <%@ include file="Navbar.jsp" %>
</head>
<body>
<h3>MY PROFILE:</h3>


<%!Temporary r;%>
		
		<%
		if(!session.isNew())
		{
			r=(Temporary)session.getAttribute("data");
			session.invalidate();
		%>
		<br><P>Account Number:=
		<%=r. getAccount_no() %>
		</P>
		<br><p>First Name:=
		<%=r.getFirstname() %>
		</p>
		<br><p>Last Name:=
		<%=r.getLastname() %>
		</p>
		<br><p>Father Name:=
		<%=r.getFather_name() %>
		</p>
		<br><p>Mother Name:=
		<%=r.getMother_name() %>
		</p>
		<br><p>DOB:=
		<%=r.getDob() %>
		</p>
		<br><p>Mobile no:=
		<%=r.getMobile_no() %>
		</p>
		<br><p>PAN no:=
		<%=r.getPan_no() %>
		</p>
		<br><p>Aadhar no:=
		<%=r.getAdhar_no() %>
		</p>
		
		
		
		<%
		}
		%>
</body>
</html>