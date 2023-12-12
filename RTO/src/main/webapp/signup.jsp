<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<script type="text/javascript">
var citiesByState = {
Karnataka: ["Bengalore","Mysore","Manglore"],
Maharashtra: ["Mumbai","Pune","Nagpur"],
Kerala: ["kochi","Kanpur"]
}
function makeSubmenu(value) {
if(value.length==0) document.getElementById("citySelect").innerHTML = "<option></option>";
else {
var citiesOptions = "";
for(cityId in citiesByState[value]) {
citiesOptions+="<option>"+citiesByState[value][cityId]+"</option>";
}
document.getElementById("citySelect").innerHTML = citiesOptions;
}
}
function displaySelected() { var country = document.getElementById("countrySelect").value;
var city = document.getElementById("citySelect").value;
alert(country+"\n"+city);
}0
function resetSelection() {
document.getElementById("countrySelect").selectedIndex = 0;
document.getElementById("citySelect").selectedIndex = 0;
}

function handleFName() {
    const fname = document.getElementById('firstName').value
    const button = document.getElementById('button');
    if (fname.length >= 3 && fname.length <= 20) {
      document.getElementById("fmsg").innerHTML = "<span style='color: green'> Name is valid </span>"
      button.removeAttribute("disabled");
    } else {
      document.getElementById("fmsg").innerHTML = "<span style='color :red'> Name is Invalid </span>"
      button.setAttribute("disabled", "");
    }
  }
function handleLName() {
    const lname = document.getElementById('lastName').value
    const button = document.getElementById('button');
    if (lname.length >= 2 && lname.length <= 10) {
      document.getElementById("lmsg").innerHTML = "<span style='color: green'> Name is valid </span>"
      button.removeAttribute("disabled");
    } else {
      document.getElementById("lmsg").innerHTML = "<span style='color :red'> Name is Invalid </span>"
      button.setAttribute("disabled", "");
    }
  }
function handlePhoneNo() {
    const phno = document.getElementById('contact').value
    const button = document.getElementById('button');
    if (phno.length === 10) {
      document.getElementById("phmsg").innerHTML = "<span style='color: green'> PhoneNumber is valid </span>"
      button.removeAttribute("disabled");
    } else {
      document.getElementById("phmsg").innerHTML = "<span style='color :red'> PhoneNumber is Invalid </span>"
      button.setAttribute("disabled", "");
    }
  }
function handleEmail() {
    const em = document.getElementById('email').value;
    const button = document.getElementById('button');
    if (em.match(/^[a-z]+@[a-z]+\.[a-z]{3}$/)) {
      document.getElementById("emsg").innerHTML = "<span style='color: green'>Email is valid</span>";
      button.removeAttribute("disabled");
    } else {
      document.getElementById("emsg").innerHTML = "<span style='color: red'>Invalid Email format</span>";
      button.setAttribute("disabled", "");
    }
  }

  function handlePasw(){
	  const pasw=document.getElementById('button');
	  const button= document.getElementById('button');
	  if(paws.match("^(?=.[A-Za-z])(?=.\d)(?=.[@$!%#?&])[A-Za-z\d@$!%*#?&]{8,}$")){
		  document.getElementById("pawsmsg").innerHTML="<span style='color: green'>Password is valid</span>";
		  button.removeAttribute("disabled");
	  }else{
		  document.getElementById("pawsmsg").innerHTML="<span style='color: green'> Minimum eight characters, at least one letter, one number and one special character required</span>";
		  button.setAttribute("disabled","");
	  }
  }
  function handleConfPass() {
    const psw = document.getElementById("password").value;
    const cpsw = document.getElementById("confirmPassword").value;
    const button = document.getElementById('button');
    if (psw === cpsw) {
      document.getElementById("cpamsg").innerHTML = "<span style='color: green'>Confirm Password matches</span>";
      button.removeAttribute("disabled");
    } else {
      document.getElementById("cpamsg").innerHTML = "<span style='color: red'>Confirm Password won't match</span>";
      button.setAttribute("disabled", "");
    }
  }
  
</script>
</head>
<body onload="resetSelection()">
	<form action="save" method="post">
		<nav class="navbar navbar-expand-lg bg-primary-subtle">
			<img src="https://itzeazy.in/blog/wp-content/uploads/2022/02/RTO-Karnataka.webp" alt="Bootstrap" width="80" height="45">
			<div class="container-fluid">

				<svg xmlns="http://www.w3.org/2000/svg" width="23" height="23" fill="currentColor" class="bi bi-house-fill" viewBox="0 0 16 16">
  <path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L8 2.207l6.646 6.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5Z" />
  <path d="m8 3.293 6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6Z" />
</svg>

				<a class="navbar-brand" href="index.jsp">Home</a>

				<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"></li>
					</ul>


					<a class="btn btn-primary" href="signin.jsp" role="button">Sign In</a>

				</div>
			</div>
		</nav>
		<font color="green" text-align="center"><h4>${success}</h4></font>
		<div class="container w-50 border border-dark border-5 mt-5">
			<div class="mb-2">
				<label class="form-label">First Name</label> <input id="firstName" type="text" name="firstName" class="form-control " required="required" oninput="handleFName()"> 
				<span id="fmsg"></span>
			</div>

			<div class="mb-3">
				<label class="form-label">Last Name</label> <input id="lastName" type="text" name="lastName" class="form-control" required="required" oninput="handleLName()">
			<span id="lmsg"></span>
			</div>

			<div class="mb-3">
				<label class="form-label">Password</label>
				 <input id="password" type="password" name="password" class="form-control" required="required" oninput="handlePasw()">
			<span id="pawsmsg"></span>
			</div>

			<div class="mb-3">
				<label class="form-label">Confirm Password</label> 
				<input id="confirmPassword" type="password" name="confirmPassword" class="form-control" required="required" oninput="handleConfPass()">
			<span id="cpamsg"></span>
			</div>

			<div class="mb-3">
				<label class="form-label">DOB</label> <input type="date" name="dob" class="form-control" required="required">
			</div>

			<div class="mb-3">
				<label class="form-label">Phone Number</label> <input id="contact" type="number" name="phoneNumber" class="form-control" required="required" oninput="handlePhoneNo()">
			<span id="phmsg"></span>
			</div>

			<select id="countrySelect" name="state" size="1" onchange="makeSubmenu(this.value)">
				<option value="" disabled selected>Choose State</option>
				<option>Karnataka</option>
				<option>Maharashtra</option>
				<option>Kerala</option>
			</select>
			
			 <select id="citySelect" name="district" size="1">
				<option value="" disabled selected>Choose City</option>
				<option></option>
			</select>
</body>

<div class="mb-3">
	<label class="form-label">E-Mail</label> 
	<input id="email" type="text" name="email" class="form-control" required="required" oninput="handleEmail()">
<span id="emsg"></span>
</div>
<font color="red"><h6>${err}</h6></font>

<div class="form-check">
	<input class="form-check-input" type="checkbox"> <label class="form-check-label" for="flexCheckDisabled"> Confirm Registration </label>
</div>

<input type="submit" type="button" class="btn btn-success">
<input class="btn btn-primary" type="reset" value="Reset">
</form>
</div>

<%@include file="footer.jsp"%>


</body>
</html>