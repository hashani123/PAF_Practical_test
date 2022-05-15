<%@page import="com.User"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management</title>
	<link rel="stylesheet" href="Views/bootstrap.min.css">
	<script src="Components/jquery-3.6.0.min.js"></script>
	<script src="Components/user.js"></script>

</head>
<body>

<div class="container"><div class="row"><div class="col-6">

	<h1>User Management</h1>


		<form id="formUser" name="formUser" method="post" action="user.jsp">
			 Name: 
			<input id="name" name="name" type="text" 
			 class="form-control form-control-sm">
			 
			<br> Address: 
			<input id="uAddress" name="uAddress" type="text" 
			 class="form-control form-control-sm">
			 
			<br> Email: 
			<input id="uEmail" name="uEmail" type="text" 
			 class="form-control form-control-sm">
			 
			<br> NIC: 
			<input id="nic" name="nic" type="text" 
			 class="form-control form-control-sm">
			 
			 <br> Phone Number: 
			<input id="Pno" name="Pno" type="text" 
			 class="form-control form-control-sm">
			 
			<br>
			<input id="btnSave" name="btnSave" type="button" value="Save" 
			 class="btn btn-primary">
			<input type="hidden" id="hidUserIDSave" name="hidUserIDSave" value="">
		</form>
		
		<div id="alertSuccess" class="alert alert-success"></div>
		<div id="alertError" class="alert alert-danger"></div>


		<br>
		<div id="divUserGrid">
		 <%
		 User UserObj = new User(); 
		 out.print(UserObj.readUser()); 
		 %>
		</div>
</div> </div> </div> 

</body>
</html>