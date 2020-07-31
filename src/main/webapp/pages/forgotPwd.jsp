<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
	
</script>
<script type="text/javascript" src="../js/checkEmailForForgotPwd.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container p-3 mb-2 bg-light text-dark ">
		<form:form action="changePwd" method="POST"
			modelAttribute="forgotPwdBinding">
			<div class="card">
				<div
					class="card-header bg-primary text-white text-uppercase text-center">
					<h2>Forgot Password</h2>
				</div>
			</div>
			<hr>
			<h3 style="color: blue;"> ${confirm}</h3>
			<div class="form-row align-items-center">
				<div class="col-4 ">
					<form:input path="email" class="form-control"
						placeholder="dillipkumar@gmail.com"/>
					<br>
				</div>
				<div class="col-4">
					<span id="userMailError"></span>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<button class="btn btn-primary" id="register">change</button>
				</div>
			</div>
		</form:form>

	</div>
</body>
</html>