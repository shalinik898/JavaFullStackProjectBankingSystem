
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
<form action="PersonalController">
 <div class="container">
 <div class="row text-center" style="color: tomato;">
  <h2></h2>
 </div>
 <hr>
  <div class="row col-md-10 col-md-offset-3"> 
   
   <div class="card card-body">
   
    <h2>Create a new account </h2>
    <div class="col-md-8 col-md-offset-3">

     

	<div class="form-group">
       <label for="uname">First Name:</label> <input type="text"
        class="form-control" id="" placeholder="Full Name"
        name="F_name" required>
      </div>
	
	<div class="form-group">
       <label for="uname">Last Name:</label> <input type="text"
        class="form-control" id="" placeholder="Last Name"
        name="L_name" required>
      </div>
	
      <div class="form-group">
       <label for="uname">Father Name:</label> <input type="text"
        class="form-control" id="" placeholder="Father Name"
        name="Father_name" required>
      </div>

      <div class="form-group">
       <label for="uname"> Mother Name:</label> <input type="text"
        class="form-control" id="uname" placeholder="Mother Name"
        name="Mother_name" required>
      </div>
       <div class="form-group">
       <label for="uname">DOB:</label> <input type="date"
        class="form-control" id="" placeholder="Date of Birth"
        name="DOB" required>
      </div>
      
      <div class="form-group">
       <label for="uname">Gender:</label> 
       <input type="radio" value="male" name="Gender" required>Male
        <input type="radio" value="female" name="Gender" required>Female
      </div>
      
       
      
      
      
      <div class="form-group">
       <label for="uname">OCCUPATION:</label> <input type="text"
        class="form-control" id="" placeholder="Occupation"
        name="Occuption" required>
      </div>
      
      <div class="form-group">
       <label for="uname">Mobile No:</label> <input type="text"
       pattern=".{10}" class="form-control" id="" placeholder="Mobile No"
        name="Mobile_no" required>
      </div>
      
      <form action="SendEmail">  
      
      <div class="form-group">
       <label for="uname">Email id:</label> <input type="email"
        class="form-control" id="" placeholder="Email id"
        name="Email_id" required>
      </div>
      
       </form>
       
       <div class="form-group">
       <label for="uname">Amount(minimum 500):</label> <input type="text"
        class="form-control" id="" placeholder="Amount"
        name="amount" required>
      </div>
      
      <button type="submit" class="btn btn-primary">DONE</button> 
			</form>
	
			<form action="AddressController">
			<table>
      
      
      <h4>ADDRESS:</h4>
		<div class="form-group">
       <label for="uname">House No:</label> <input type="text"
        class="form-control" id="branch" placeholder="House No"
        name="House_no" required>
      </div>
      
		
      <div class="form-group">
       <label for="uname">Street No:</label> <input type="text"
        class="form-control" id="username" placeholder="Street No"
        name="Street" required>
      </div>

      <div class="form-group">
       <label for="uname">City:</label> <input type="text"
        class="form-control" id="" placeholder="City"
        name="City" required>
      </div>

		
      
      <div class="form-group">
       <label for="uname">Pincode:</label> <input type="text"
        pattern=".{6}" class="form-control" id="" placeholder=""
        name="Pincode" required>
      </div>
      
      <div class="form-group">
       <label for="uname">State:</label> <input type="text"
        class="form-control" id="" placeholder="State"
        name="State" required>
      </div>
      
     <button type="submit" class="btn btn-primary">DONE</button>
      
      
      </form>
      
      
      <form action="UploadController">
      
      <h2>DOCUMENTS:</h2>
       <div class="form-group">
       <label for="uname">Aadhar Number:</label> <input type="text"
      pattern=".{12}"  class="form-control" id="" placeholder="Aadhar No)"
        name="Adhar_no" required>
      </div>
      
       <div class="form-group">
       <label for="uname">PAN CARD Number:</label> <input type="text"
      pattern=".{10}"  class="form-control" id="" placeholder="PANCARD NO"
        name="PAN_no" required>
      </div>
      
       
       
       
		
      <button type="submit" class="btn btn-primary">DONE</button>

     </form>
    </div>
   </div>
  </div>
 </div>
</body>
</html>