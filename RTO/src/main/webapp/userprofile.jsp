<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary navbar-light fw-bold d-flex justify-content-between align-items-center" data-bs-theme="dark">

		<img src="https://t3.ftcdn.net/jpg/05/18/89/00/360_F_518890058_o7xox3YLS0e27k5kHWUTQXaw1yLAvM7p.jpg" alt="Bootstrap" width="60" height="45">

		<div class="container-fluid">

			<svg xmlns="http://www.w3.org/2000/svg" width="23" height="23" fill="currentColor" class="bi bi-house-fill" viewBox="0 0 16 16">
  <path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L8 2.207l6.646 6.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5Z" />
  <path d="m8 3.293 6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6Z" />
</svg>

			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item" style="list-style-type: none;"><a class="nav-link active" aria-current="page" href="index.jsp">Home</a></li>
			</ul>

			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"></li>
				</ul>


			</div>
		</div>
	</nav>
     
<h1 style="text-align: center;">User Profile</h1>
<form action="userlogin" method="get">
		<table class="table table-bordered"  align="center">
			<tr>

				
				<th>FirstName</th>
				<th>LastName</th>
				<th>Dob</th>
				<th>PhoneNumber</th>
				<th>Email</th>
				<th>ApplicationNumber</th>
				<th>Status</th>
				</tr>
			
			<tr>
		    	
		    <td>${udt.firstName}</td>	
		    <td>${udt.lastName}</td>		
		    <td>${udt.dob}</td>	
		    <td>${udt.phoneNumber}</td>	
		    <td>${udt.email}</td>
		    <td>${udt.applicationNumber}</td>
		    <td>${udt.status}</td>
		    
		     </tr>
		    </table>  
		    </form>
       </body>

</html>
	
