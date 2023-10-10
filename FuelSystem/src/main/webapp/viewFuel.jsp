<%@page import="Fuel.Class.*"%>
<%@page import="Fuel.Service.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>Fuel System</title>
	
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/croppie.js"></script>
    <link rel="stylesheet" href="assets/css/croppie.css" />

    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <script src="assets/js/sweetalert.min.js"></script>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.js"></script>
	<style type="text/css">
        .my-error-class {
            color:red;
        }
        .my-valid-class {
            color:green;
        }
    </style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light" style="background:blue; border:5px solid CornflowerBlue;">
    	<div class="container" style="background-color:PaleTurquoise;" >
	        <h3 class="navbar-brand" href="user.jsp"> Online Vehicle service and Fuel Station Management System</h3>
	        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	            <span class="navbar-toggler-icon"></span>
	        </button>
	
	        <div class="collapse navbar-collapse" id="navbarSupportedContent">
	            <ul class="navbar-nav ml-auto">
	            <% if(session.getAttribute("userEmail")==null){ %>
	                <li class="nav-item">
	                    <h5><a class="nav-link" href="login.jsp">Login &nbsp; |</a></h5>
	                </li>
	                <li class="nav-item">
	                   <h5> <a class="nav-link" href="register.jsp">Register</a></h5>
	                </li>
	                <%}else{ %>
	                <li class="nav-item">
	                    <a class="nav-link" href="logoutServlet">Logout</a>
	                </li>
	                <%} %>
	            </ul>
	
	        </div>
        </div>
	</nav>
    <div class="container">
		
<br>
<p></p>
		<main class="login-form">
	        <div class="row justify-content-center">
	            <div class="col-md-10">
	                <div class="card">
	                    <div class="card-header" style="background-color:LightSkyBlue;">All Fuels Details</div>
	                    <%
							if(request.getAttribute("results")!=null){// will show if the eried action is success or not
								if(request.getAttribute("results").equals(1)){
									%>	<div class="alert alert-success">
										  Successful!
										</div>	<%
								}else{
									%>	<div class="alert alert-danger">
										  Unsuccessful!
										</div>	<%
								}
							}
						%>
	                    <div class="p-1" id="usersDiv">
	                    	<table class="table">
			                    <thead>
					                <tr>
					                    <th class="tableTh">ID</th>
					                    <th class="tableTh">Stock Volume</th>
					                    <th class="tableTh">Intial Volume</th>
					                    <th class="tableTh">Date Received</th>
					                    <th class="tableTh">Date Consumed</th>
					                    <th class="tableTh">Edit</th>
					                    <th class="tableTh">Remove</th>
					                </tr>
				                </thead>
			                <tbody>
	                	<%//java tags 
	                		FuelService f = new FuelService();// fule object is created and fet fuel method is called
							ArrayList<Fuel> arrayList = f.getFuels();
							
							for (Fuel fuel_s : arrayList) { //data is returned s an arraylist for that for loop is used
								
								
						%><tr>
							<td class="tableTh"><%=fuel_s.getId() %></td>
							<td class="tableTh"><%=fuel_s.getStock_volume() %></td>
							<td class="tableTh"><%=fuel_s.getIntial_volume() %></td>
							<td class="tableTh"><%=fuel_s.getDate_recieved() %></td>
							<td class="tableTh"><%=fuel_s.getDate_consumed() %></td>
							<td class="tableTh"><a class="btn btn-success" href="getFuel?id=<%=fuel_s.getId() %>" >Edit</a></td>
							<td class="tableTh"><Button class="btn btn-danger" id="<%=fuel_s.getId() %>" onclick="clickDelete(this);">Delete</Button></td>
						  </tr>
						<%
							}
						%>
						</tbody>
	            </table>
	            </div>
	                </div>
	            </div>
	        </div>
		</main>
	</div>

	
	<div style="display: none;" >
    	<form action="deleteFuel" method="post" id="settingsForm">
			<input name="deleteId" id="deleteId" required>
		</form>
    </div>

</body>
</html>
<script>
	
	function clickDelete(id){   //for delete a js function is used
		
		var r = confirm("If you want remove data ?");//an id is receieved from te function and it is inserted to the form and passed to servlet.
		if (r == true) {
		  
			var did = id.id;
		
			document.getElementById("deleteId").value = did;
			
			document.getElementById("settingsForm").submit();
			
		}
		
	}

</script>