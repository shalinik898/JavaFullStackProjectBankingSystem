<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>




<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
 <%@ include file="Dashboard.jsp" %>
</head>

</head>
<body>

 <div class="container">
 <div class="row text-center" style="color: tomato;">
  <h2></h2>
 </div>
 <hr>
  <div class="row col-md-10 col-md-offset-3"> 
   
   <div class="card card-body">
   
    <h2> Update Password</h2>
    <div class="col-md-8 col-md-offset-3">
<form action="UpdateController">
     

			
      <div class="form-group">
       <label for="uname">Username:</label> <input type="text"
        class="form-control" id="current password" placeholder="Password"
        name="username" required>
      </div>

      <div class="form-group">
       <label for="uname">New Password:</label> <input type="password"
        class="form-control" id="new password" placeholder="Password"
        name="password" required>
      </div>

      <button type="submit" class="btn btn-primary">Done</button>
      <button type="submit" class="btn btn-primary">Cancel</button>

     </form>
    </div>
   </div>
  </div>
 </div>
</body>
</html>