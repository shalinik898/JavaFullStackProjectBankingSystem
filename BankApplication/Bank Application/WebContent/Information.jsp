<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <%@ include file="Dashboard.jsp" %>

</head>
<body>
<h3>Information:</h3>


<c:if test="${requestScope.empList !=null and not empty requestScope.empList}">
<table border="1" cellpadding="3">
	<tr>
		<td>sr No</td>
		<td>First Name</td>
		<td>Last Name</td>
		<td>Father Name</td>
		<td>Mother Name</td>
		<td>Date of Birth</td>
		<td>Gender</td>
		<td>Occupation</td>
		<td>Mobile number</td>
		<td>Email id</td>
		<td>Amount</td>
		<td>House no</td>
		<td>Street</td>
		<td>city</td>
		<td>Pincode</td>
		<td>State</td>
		<td>Adhar_no</td>
		<td>Pan_no</td>
		
		
	</tr>
	<c:forEach items="${requestScope.empList}" var="e"> 		
	<tr>
		<td>${e.sr_no}</td>
		<td>${e.firstname}</td>
		<td>${e.lastname}</td>
		<td>${e.father_name}</td>
		<td>${e.mother_name}</td>
		<td>${e.dob}</td>
		<td>${e.gender}</td>
		<td>${e.occuption}</td>
		<td>${e.mobile_no}</td>
		<td>${e.email_id}</td>
		<td>${e.amount}</td>
		<td>${e.house_no}</td>
		<td>${e.street}</td>
		<td>${e.city}</td>
		<td>${e.pincode}</td>
		<td>${e.state}</td>
		<td>${e.adhar_no}</td>
		<td>${e.pan_no}</td>
		
		
	</tr>
	</c:forEach>
</table></c:if>

</body>
</html>