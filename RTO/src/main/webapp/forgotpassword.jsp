<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary navbar-light fw-bold d-flex justify-content-between align-items-center" data-bs-theme="dark">

		<img
			src="https://t3.ftcdn.net/jpg/05/18/89/00/360_F_518890058_o7xox3YLS0e27k5kHWUTQXaw1yLAvM7p.jpg"
			alt="Bootstrap" width="100" height="50">

		<div class="container-fluid">


			<a class="navbar-brand" href="index.jsp">Home</a>

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			</div>
			</nav>
			
			<div class="container w-50 border border-dark border-5 mt-5">
 			
		<form action="pass" method="get">

			<div class="mb-3">
				<label class="form-label">Email</label> <input type="text"
					value="${emailId}" name="email" class="form-control" required="required" >
			</div>
			
		
			<h1>${otp}</h1>
			<input type="submit" value="SendOtp" name="navi" class="btn btn-success"/>
			
<!-- 			<form action="checkotp" method="get">
 --><div class="mb-3">
				<label class="form-label">OTP</label> <input type="text"
					name="otp" class="form-control" >
					</div>
							<div class="mb-3">
					
								<input type="submit" value="next" name="navi" class="btn btn-success"/>
					</div>
			
			

</form>
 </div>
 
 
</body>
<%@include file="footer.jsp" %>

</html>