<!--
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="BeneficiaryController">
		<table border=5>
		<tr><td>Beneficiary_Name</td><td> <input type="text" name="beneficiaeryname"></td></tr><br>
		<tr><td>Acc no</td><td> <input type="text" name="accno"></td></tr><br>
		<tr><td>Branch</td><td> <input type="text" name="branch"></td></tr><br>
		<tr><td>BeneficiaryAmount</td><td> <input type="text" name="beneficiaryamount"></td></tr><br>
		
		<input type="submit" name="add" value="add"><br>
		</table>
		</form>


</body>
</html>-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

   <link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
 <%@ include file="Dashboard.jsp" %>
 </head>


<body>
<form action="BeneficiaryController">
   <h2 align="center" >Beneficiary Details</h2>
 <div class="container">
 <div class="row text-center" style="color: tomato;">
  
 </div>
 <hr>
  <div class="row col-md-20 col-md-offset-5"> 
   
   <div class="card card-body">
    
  <div class="btn-group btn-group-xs">
    <button type="button" class="btn btn-primary">Add</button>
    <button type="button" class="btn btn-primary">Delete</button>
    
  </div> 
    
    <div class="col-md-8 col-md-offset-3">

    

			
      <div class="form-group">
       <label for="uname"> Beneficiary Name:</label> <input type="text"
        class="form-control" id="username" placeholder="Beneficiary Name"
        name="beneficiaeryname" required>
      </div>

      <div class="form-group">
       <label for="uname">Account No:</label> <input type="text"
        class="form-control" id="password" placeholder="Beneficiary Account No"
        name="accno" required>
      </div>

	  <div class="form-group">
       <label for="uname">Branch:</label> <input type="text"
        class="form-control" id="password" placeholder="Branch"
        name="branch" required>
      </div>
	
      <button type="submit" class="btn btn-primary">Done</button>

     
    </div>
   </div>
  </div>
 </div>
 </form>
</body>
</html>