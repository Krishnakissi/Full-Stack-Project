<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>profile</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" 
 rel="stylesheet" 
 integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
  crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary navbar-light fw-bold d-flex justify-content-between align-items-center" data-bs-theme="dark">

<img src="https://t3.ftcdn.net/jpg/05/18/89/00/360_F_518890058_o7xox3YLS0e27k5kHWUTQXaw1yLAvM7p.jpg" alt="Bootstrap" width="60" height="45">

<div class="container-fluid">

<svg xmlns="http://www.w3.org/2000/svg" width="23" height="23" fill="currentColor" class="bi bi-house-fill" viewBox="0 0 16 16">
  <path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L8 2.207l6.646 6.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5Z"/>
  <path d="m8 3.293 6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6Z"/>
</svg>

<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item" style="list-style-type: none;"><a class="nav-link active" aria-current="page" href="index.jsp">Home</a></li>
			</ul>
			    
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
        
        </li>
        </ul>
        
        

			<div class="d-flex">
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link" role="button" name="firstName" href=""><b>Hi,${dtos}</b></a></li>
					</ul>

					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link" role="button" href="index.jsp"><b>Logout</b></a></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>
	<div>
		<h1 class="text-center">RTO detail</h1>
		<table class="table table-bordered pd-5">
			
				<tr>
					<th>FirstName</th>
					<th>LastName</th>
					<th>DateOfBirth</th>
					<th>EmailId</th>
					<th>MobileNumber</th>
					<th>State</th>
					<th>District</th>
					<th>Password</th>
					<th>Resgistered DateAndTime</th>
				</tr>

		    	<tr>
		    <td>${Dto.firstName}</td>	
		    <td>${Dto.lastName}</td>	
		    <td>${Dto.password}</td>	
		    <td>${Dto.confirmPassword}</td>	
		    <td>${Dto.dob}</td>	
		    <td>${Dto.phoneNumber}</td>	
		    		    <td>${Dto.state}</td>	
		    		    <td>${Dto.district}</td>
		    		    <td>${Dto.registerDateTime})</td>	
		    
		    
		    </tr>
		    </table>
		    
		    
	     <h1>${updateMessage}</h1>
 	    
 				     <form action="userState" method="get">
 
				    <h1 class="text-center">LLR detail</h1>
		
		<table class="table table-bordered pd-5">
			
				<tr>
					<th>FirstName</th>
					<th>email</th>
					<th>state</th>
					<th>status</th>
					<th>applicationNumber</th>
					</tr>
					 	              										    	
					
				<c:forEach items="${udtos}" var="s">
 	              
   <tr>
		    	               <td>${s.firstName}</td>
		    			    	<td>${s.email}</td>
		    			    	<td>${s.state}</td>
		    			    	<td>${s.status}</td>
		    			    	<td>${s.applicationNumber}</td>
		    			    	<td><font color="blue">${s.status}</font></td>
		    			    	<td><a href=updateUserStatus?id=${s.id}>Approve</a></td>
		    			    	</tr>
    			    	</c:forEach>
     		 	    	</table>
		    
	</div>
		</form>
	
	<%@include file="footer.jsp"%>
</body>
</html>