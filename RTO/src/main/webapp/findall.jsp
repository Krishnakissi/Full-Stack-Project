<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>rto findall</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<div style="text-align: center;">
</head>
<body>
	<form action="findAll" method="get">

		<nav class="navbar navbar-expand-lg bg-info">
			<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQE_8KMvgjD-gk2gbjB_5qRCQyivcQikWHZVg&usqp=CAU" alt="Bootstrap" width="100" height="50">

			<div class="container-fluid">

				<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-house-door-fill" viewBox="0 0 16 16">
  <path
						d="M6.5 14.5v-3.505c0-.245.25-.495.5-.495h2c.25 0 .5.25.5.5v3.5a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5Z" />
</svg>
				<a class="navbar-brand" href="index.jsp">Home</a>
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


		<h1 style="text-align: center;">RTO Info</h1>
		<table class="table table-bordered" align="center">
			<tr>

				<!-- <th>Id</th>  -->
				<th>FirstName</th>
				<th>LastName</th>
				<th>Password</th>
				<th>ConfirmPassword</th>
				<th>Dob</th>
				<th>PhoneNumber</th>
				<th>Email</th>
			</tr>




			<c:forEach items="${dtos}" var="Dto">
				<tr>
					<%--  <td>${Dto.id}</td> 	 --%>
					<td>${Dto.firstName}</td>
					<td>${Dto.lastName}</td>
					<td>${Dto.password}</td>
					<td>${Dto.confirmPassword}</td>
					<td>${Dto.dob}</td>
					<td>${Dto.phoneNumber}</td>
					<td>${Dto.email}</td>
				</tr>
			</c:forEach>

		</table>
		<input type="submit" text-align="center">
	</form>
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
