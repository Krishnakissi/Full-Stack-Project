<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>adminprofile</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-primary-subtle">
		<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQE_8KMvgjD-gk2gbjB_5qRCQyivcQikWHZVg&usqp=CAU" alt="Bootstrap" width="100" height="50">
 
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
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"></li>
				</ul>

        <a class="btn btn-primary" href="signup.jsp" role="button" class="me-4">SignUp</a>


				<div class="d-flex">
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav me-auto mb-2 mb-lg-0">
							<li class="nav-item"><a class="nav-link" role="button"
								name="firstName" href=""><b>Hi,${dt.firstName}
										${dt.lastName}</b></a></li>
						</ul>

						<ul class="navbar-nav me-auto mb-2 mb-lg-0">
							<li class="nav-item"><a class="nav-link" role="button"
								href="index.jsp"><b>Logout</b></a></li>
						</ul>
					</div>
				</div>
			</div>
	</nav>

	<div>
		<h1 class="text-center">RTO Admin detail</h1>
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
				<th>ConfirmPassword</th>
				<th>RegisteredDateTime</th>
			</tr>
			<tr>

				<td>${dt.firstName}</td>
				<td>${dt.lastName}</td>
				<td>${dt.password}</td>
				<td>${dt.confirmPassword}</td>
				<td>${dt.dob}</td>
				<td>${dt.phoneNumber}</td>
				<td>${dt.state}</td>
				<td>${dt.district}</td>
				<td>${dt.email}</td>
				<td>${dt.registerDateTime}</td>
			</tr>


		</table>
	</div>
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
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	
	<%@include file="footer.jsp"%>
</body>
</html>