

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="Navbar.jsp" %>

<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>

</head>
<body>
<form action="RegistrationServlet" >
 <div class="container">
 <div class="row text-center" style="color: tomato;">
  <h2></h2>
 </div>
 <hr>
  <div class="row col-md-10 col-md-offset-3"> 
   
   <div class="card card-body">
   
    <h2> Registration Form</h2>
    <div class="col-md-8 col-md-offset-3">

    

	<div class="form-group">
       <label for="uname">Account No:</label> <input type="text"
       pattern=".{11}" class="form-control" id="accno" placeholder="Account No"
        name="account_no" required>
      </div>
	
      <div class="form-group">
       <label for="uname">First Name:</label> <input type="text"
        class="form-control" id="uname" placeholder="First Name"
        name="firstname" required>
      </div>

      <div class="form-group">
       <label for="uname">Last Name:</label> <input type="text"
        class="form-control" id="uname" placeholder="last Name"
        name="lastName" required>
      </div>
      
	 	<div class="form-group">
       <label for="uname">Mobile Number:</label> <input type="text"
        class="form-control" id="mobile_no" placeholder="mobile no"
        name="mobile_no" required>
      </div>   
	
	    
		
      <div class="form-group">
       <label for="uname">User Name:</label> <input type="text"
        class="form-control" id="username" placeholder="User Name"
        name="username" required>
      </div>

      <div class="form-group">
       <label for="uname">Password:</label> <input type="password"
        class="form-control" id="password" placeholder="Password"
        name="password" required>
      </div>

      <button type="submit" class="btn btn-primary">Register</button>
</form>
    </div>
   </div>
  </div>
 </div>
</body>
</html>