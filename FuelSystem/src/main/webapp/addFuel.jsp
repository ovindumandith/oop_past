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
        #bt21{
        
          
          background-color: #007bff;
          border-color: #007bff;
          color: white;
          font-weight: 400;
          font-color:none;
          text-align: center;
          vertical-align: middle;
          cursor: pointer;
          position:absolute;
          margin-left:850px;
          margin-top:-80px;
         
          border:3px solid ;
          padding: 8.5px;
          font-size: 1rem;
          line-height: 1.5;
          border-radius: 0.5rem;
         
        
        
        }
        main{
        
        padding:20px;
        }
        body{
       background: #E0EAFC;  /* fallback for old browsers */
background: -webkit-linear-gradient(to bottom, #CFDEF3, #E0EAFC);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to bottom, #CFDEF3, #E0EAFC); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
       
        }
        
        
    </style>
</head>
<body >
	<nav class="navbar navbar-expand-lg navbar-light bg-light" style="background:blue; border:5px solid CornflowerBlue;">
    	<div class="container" style="background-color:PaleTurquoise;" >
	        <h3 class="navbar-brand" href="user.jsp"> Online Vehicle service and Fuel Station Management 
System</h3>
	        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	            <span class="navbar-toggler-icon"></span>
	        </button>
	
	        <div class="collapse navbar-collapse" id="navbarSupportedContent">
	            <ul class="navbar-nav ml-auto">
	                <% if(session.getAttribute("userEmail")==null){ %>
	                <li class="nav-item">
	                   <h5> <a class="nav-link" href="login.jsp">Login &nbsp; |</a></h5>
	                </li>
	                <li class="nav-item">
	                    <h5> <a class="nav-link" href="register.jsp">Register</a> </h5>
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
		<main class="login-form" >
	
	        <div class="row justify-content-center">
	            <div class="col-md-8">
	                <div class="card" >
	                    <div class="card-header" style="background-color:LightSkyBlue;">Add Fuel Details</div>
	                    <div class="card-body">
	                    <%
							if(request.getAttribute("results")!=null){//sett the data is null or not(for the first time if acessed)
								if(request.getAttribute("results").equals(1)){//if created print the div successful
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
	                        <form action="addFuel" method="post"><!--  data is passed to servlet through post method-->
	                            <div class="form-group row">
	                                <label for="email_address" class="col-md-4 col-form-label text-md-right">Stock Volume</label>
	                                <div class="col-md-6">
	                                    <input type="number" id="stock_volume" class="form-control" name="stock_volume" required>
	                                </div>
	                            </div>
	                            
	                            <div class="form-group row">
	                                <label for="email_address" class="col-md-4 col-form-label text-md-right">Intial Volume</label>
	                                <div class="col-md-6">
	                                    <input type="number" id="intial_volume" class="form-control" name="intial_volume" required>
	                                </div>
	                            </div>
	                            
	                            <div class="form-group row">
	                                <label for="email_address" class="col-md-4 col-form-label text-md-right">Date Received</label>
	                                <div class="col-md-6">
	                                    <input type="date" id="date_recieved" class="form-control" name="date_recieved" required>
	                                </div>
	                            </div>
	                            
	                            <div class="form-group row">
	                                <label for="email_address" class="col-md-4 col-form-label text-md-right">Date Consumed</label>
	                                <div class="col-md-6">
	                                    <input type="date" id="date_consumed" class="form-control" name="date_consumed" required>
	                                </div>
	                            </div>
	                            
	                            <div class="col-md-6 offset-md-4">
	                                <button type="submit" class="btn btn-primary">
	                                    Add
	                                </button>
	
	                            </div>
	                    	</form>
	                    	                                
	                    </div>
	                </div>
	            </div>
	        </div>
		</main>
	</div>
<div >  <a href="viewFuel.jsp">
      <input type="submit" value="View Added Fuel" id="bt21"/>
    </a></div>
</body>
</html>

<script>
$(document).ready(function(){


        $('#image').on('change', function(){
            var form_data = new FormData($('#sample_form')[0]);
        	$.ajax({
                type: "POST",
                enctype: 'multipart/form-data',
            	url:"imageUploadServlet",
                data: form_data,
                processData: false,
                contentType: false,
                success:function(data)
                {
                    $('#imagePath').val(data);
                }
            })
        });

    });
    
    function checkUpload(){
    	
    	if($('#imagePath').val()==""){
    		swal({
	            title: "Error",
	            text: "Please Upload Image!",
	            icon: "warning",
	            dangerMode: true,
	        });
    		return false;
    	}else{
    		return true;
    	}
    }
    
</script>