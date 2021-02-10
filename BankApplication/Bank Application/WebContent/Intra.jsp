<!--<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="IntraController">
		<table border=5>
		<tr><td>Beneficiary_accno</td><td> <input type="text" name="beneficiaryaccno"></td></tr><br>
		<tr><td>Sender_accno</td><td> <input type="text" name="senderaccno"></td></tr><br>
		<tr><td>Amount</td><td> <input type="text" name="amount"></td></tr><br>
		<tr><td>Remark</td><td> <input type="text" name="remark"></td></tr><br>
		<tr><td>Payment_date</td><td> <input type="text" name="paymentdate"></td></tr><br>
		
		
		
		<input type="submit" name="transfer" value="transfer"><br>
		</table>
		</form>
		<label for="uname">AMOUNT:</label> <input type="text"
        pattern=".{11}" class="form-control" id="amount" placeholder="Amount"
        name="amount" required>
        <label for="uname">REMARK:</label> <input type="text"
        pattern=".{11}" class="form-control" id="remark" placeholder="Remark"
        name="remark" required>
        <label for="uname">PAYMENT DATE:</label> <input type="text"
        pattern=".{11}" class="form-control" id="paymentdate" placeholder="Payment date"
        name="paymentdate" required>
      
     
      
	
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

</head>
<body>
<form action="IntraController">
 <div class="container">
 <div class="row text-center" style="color: tomato;">
  <h2></h2>
 </div>
 <hr>
  <div class="row col-md-10 col-md-offset-3"> 
   
   <div class="card card-body">
   
    <h2>INTRA TRANSACTION</h2>
    <div class="col-md-8 col-md-offset-3">

     

			
      <div class="form-group">
       <label for="uname">BENEFICIARY ACCOUNT NO:</label> <input type="text"
       pattern=".{11}" class="form-control" id="beneficiaryaccno" placeholder="Bebeficiary Account No"
        name="beneficiaryaccno" required>
      </div>

      <div class="form-group">
       <label for="uname">SENDER ACCOUNT NO:</label> <input type="text"
        pattern=".{11}" class="form-control" id="senderaccno" placeholder="Remitter Account No"
        name="senderaccno" required>
      </div>
      
       <div class="form-group">
       <tr><td>Amount</td><td> <input type="text" name="amount"></td></tr><br>
       </div>
      
      <div class="form-group">
      <tr><td>Remark</td><td> <input type="text" name="remark"></td></tr><br>
        </div>
      
      <div class="form-group">
      <tr><td>Payment_date</td><td> <input type="text" name="paymentdate"></td></tr><br>
       </div>
      
      

		<div>
      <button type="submit" class="btn btn-primary">Transfer</button>
      </form>
      <a href="Cancel.jsp"><button type="submit" class="btn btn-primary">Cancel</button></a>
      </div>

     
    </div>
   </div>
  </div>
 </div>
</body>
</html>