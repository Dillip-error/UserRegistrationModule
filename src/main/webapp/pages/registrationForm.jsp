<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
	
</script>
<style type="text/css">
b{
color: blue;
}
</style>

<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js">
	
</script>

<script type="text/javascript" src="../js/app.js"></script>
<script type="text/javascript" src="../js/ajax.js"></script>

</head>

<body>

	<form:form action="save" method="POST"
		modelAttribute="registrationEntity">

		<div class="container p-3 mb-2 bg-light text-dark "style="background-image: url('../images/Background.jpg');">


			<div class="card">
				<div
					class="card-header bg-primary text-white text-uppercase text-center">
					<h2>
						User Registration Form
					</h2>
				</div>
			</div>


			<div class="row">
				<div class="col-4 ">
					<label for="fname"><b>First Name</b></label>
				</div>
				<div class="col-4 p-1">
					<%-- <form:hidden path="password" /> --%>
					<input type="text" class="form-control" placeholder="First name"
						name="firstName" id="fname">
				</div>
				<div class="col-4">
					<span id="fNameError"></span>
				</div>
			</div>

			<div class="row">
				<div class="col-4">
					<label for="lname"><b>Last Name</b></label>
				</div>

				<div class="col-4 p-1">
					<input type="text" class="form-control" placeholder="Last name"
						name="lastName" id="lname">
				</div>
				<div class="col-4">
					<span id="lNameError"></span>
				</div>
			</div>

			<div class=" row">
				<div class="col-4">
					<label for="email"><b>Email Adrss</b></label>
				</div>
				<div class="col-4 p-1">
					<input type="email" class="form-control" id="email"
						placeholder="dillipksahoo1996@gmail.com" name="email">
				</div>
				<div class="col-4">
					<span id="userMailError"></span>
				</div>

			</div>

			<div class="row">
				<div class="col-4">
					<label for="no"><b>Phone No</b></label>
				</div>

				<div class="col-4 p-1">
					<input type="text" class="form-control" placeholder="phone number"
						name="phoneNo" id="no">
				</div>

				<div class="col-4">
					<span id="userContactError"></span>
				</div>
			</div>

			<div class="row">
				<div class="col-4">
					<label for="dob"><b>D.O.B</b></label>
				</div>

				<div class="col-4 p-1">
					<input type="date" class=" form-control" id="dob"
						placeholder="Select Date" name="DOB">
				</div>

				<div class="col-4">
					<span id="dobError"></span>
				</div>
			</div>


			<div class="row">
				<div class="col-4">
					<label for="gen"><b>Gender</b></label>
				</div>

				<div class="col-4 p-1 ">

					 

					  <input type="radio"  name="gender" id="gen" value="male"><b>MALE</b>
					<input type="radio" name="gender" id="gen" value="female"><b>FEMALE</b>
					<input type="radio" name="gender" id="gen" value="other"><b>OTHER</b> 
 
				</div>

				<div class="col-4">
					<span id="spnError" class="error" style="display: none">
						<p style="color: red;">
							Please select <b>Gender.</b>
						</p>
					</span>
				</div>

			</div>

			<div class="row">
				<div class="col-4">
					<label for="countryId"><b>Country Name</b></label>
				</div>

				<div class="col-4 p-1">
					<form:select class="form-control" path="countryId">
						<form:option value="">Choose Country...</form:option>
						<form:options items="${allCountryIdName}" />
					</form:select>
				</div>

				<div class="col-4">
					<span id="countryError"></span>
				</div>
			</div>

			<div class="row">
				<div class="col-4">
					<label for="stateId"><b>State Name</b></label>
				</div>

				<div class="col-4 p-1">
					<form:select class="form-control" path="stateId">
						<form:option value="">Choose State...</form:option>
					</form:select>
				</div>

				<div class="col-4">
					<span id="stateError"></span>
				</div>
			</div>

			<div class="row">
				<div class="col-4">
					<label for="cityId"><b>City Name</b></label>
				</div>


				<div class="col-4 p-1">
					<form:select class="form-control" path="cityId">
						<form:option value="">Choose City...</form:option>
					</form:select>
				</div>

				<div class="col-4">
					<span id="cityError"></span>
				</div>
			</div>



			<div class="row">

				<div class="col-4 ">
					<input type="reset" value="Reset" class="btn btn-warning" />
				</div>

				<div class="col-4 ">
					<input type="submit" value="submit" class="btn btn-primary"
						id="register">
				</div>

			</div>

			<c:if test="${!empty msg}">
				<div class="card-footer bg-info text-white text-center p-1">
					<h3>${msg}</h3>
					<h3>
						<a
							href="send?url=https://accounts.google.com/AccountChooser/signinchooser?flowName=GlifWebSignIn&flowEntry=AccountChooser/">click
							here to Check your Mail...</a>
					</h3>
				</div>
			</c:if>
		</div>

	</form:form>
</body>
</html>







