<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<%@ include file="Navbar.jsp" %>


<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
</head>

</head>
<body>
<form action="LoginServlet">
 <div class="container">
 <div class="row text-center" style="color: tomato;">
  <h2></h2>
 </div>
 <hr>
  <div class="row col-md-10 col-md-offset-3"> 
   
   <div class="card card-body">
   
    <h2> Login Form</h2>
    <div class="col-md-8 col-md-offset-3">

     

			
      <div class="form-group">
       <label for="uname">User Name:</label> <input type="text"
        class="form-control" id="username" placeholder="User Name"
        name="Username" required>
      </div>

      <div class="form-group">
       <label for="uname">Password:</label> <input type="password"
        class="form-control" id="password" placeholder="Password"
        name="Password" required>
      </div>

      <button type="submit" class="btn btn-primary">Login</button>
           </form>
           <%!String a;%>
		
		<%
		if(!session.isNew())
		{
			a=(String)session.getAttribute("data");
			
			session.invalidate();
		%>
		
		<%=a %>
		
		<%
		}
		%>
		
    </div>
   </div>
  </div>
 </div>
</body>
</html>