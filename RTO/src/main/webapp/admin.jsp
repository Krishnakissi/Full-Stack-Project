<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admin</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">

</head>
<body>
	<nav class="navbar navbar-expand-lg bg-primary-subtle">
		<img
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQE_8KMvgjD-gk2gbjB_5qRCQyivcQikWHZVg&usqp=CAU"
			alt="Bootstrap" width="100" height="50">

		<div class="container-fluid">

			<svg xmlns="http://www.w3.org/2000/svg" width="23" height="23"
				fill="currentColor" class="bi bi-house-fill" viewBox="0 0 16 16">
  <path
					d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L8 2.207l6.646 6.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5Z" />
  <path
					d="m8 3.293 6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6Z" />
</svg>

			<a class="navbar-brand" href="index.jsp">Home</a>

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
				<a class="navbar-brand" href="searchbystate.jsp">SearchByState</a>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"></li>
				</ul>


			</div>
		</div>
	</nav>
	<div class="container w-50 border border-dark border-5 mt-5">
			
		<form action="admin" method="get">

			<div class="mb-3">
				<label class="form-label">Email</label> <input type="text"
				value="${emailId}"	name="email" class="form-control" required="required">
			</div>
			
<h1>${otp}</h1>
			<input type="submit" value="sendOtp" name="admn" class="btn btn-success"> 
 


			
			<div class="mb-3">
				<label class="form-label">OTP</label> <input type="text"
					name="otp" class="form-control" >
			
			
			
			

		<input type="submit" value="next" name="admn" class="btn btn-success">
		</div>
		</form>
	
</body>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

<%@include file="footer.jsp"%>
</html>