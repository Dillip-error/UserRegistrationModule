<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<link rel="stylesheet" type="text/css" href="../css/login.css">
</head>
<body>





	<section class="login-block">
		<div class="container">

			<div class="row">
				<div class="col-md-4 login-sec">
					<h2 class="text-center">Login Now</h2>
					<h3 style="color: red;">${errorMsg}</h3>
					<h3 style="color: blue;">${msg}</h3>
					<h3 style="color: red;">${accStatus}</h3>
					<form:form class="login-form" method="POST" action="logindata"
						modelAttribute="logInBind">
						<div class="form-group">
							<label for="exampleInputEmail1" class="text-uppercase">Username</label>
							<form:input type="text" path="email" class="form-control"
								placeholder="Email.." required="required" />

						</div>
						<div class="form-group">
							<label for="exampleInputPassword1" class="text-uppercase">Password</label>
							<form:input type="password" path="password" class="form-control"
								placeholder="Password.." required="required" />
						</div>


						<div class="form-check">
							<label class="form-check-label"> <input type="checkbox"
								class="form-check-input"> <small>Remember Me</small>
							</label>
							<button type="submit" class=" btn btn-primary  float-right">Submit</button>
						</div>
						<br>

						<div class="row">
							<div class="col-4">
								<label> <a href="#"><b>Sign Up</b></a>
								</label>
							</div>
							<div class="col-8">
								<label> <a href="/forgotpwd"><b>Forgot Pwd?</b></a>
								</label>
							</div>

						</div>

					</form:form>

					<div class="copy-text">
						Created with <i class="fa fa-heart"></i> by <a
							href="http://ashok.in">AshokIt.com</a>
					</div>

				</div>

				<div class="col-md-8 banner-sec">
					<div id="carouselExampleIndicators" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#carouselExampleIndicators" data-slide-to="0"
								class="active"></li>
							<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
							<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
						</ol>
						<div class="carousel-inner" role="listbox">
							<div class="carousel-item active">
								<img class="d-block img-fluid"
									src="https://images.pexels.com/photos/872957/pexels-photo-872957.jpeg"
									alt="First slide">
								<div class="carousel-caption d-none d-md-block">
									<div class="banner-text">
										<h2>This is First Slide</h2>
										<p>Lorem ipsum dolor sit amet, consectetur adipiscing
											elit, sed do eiusmod tempor incididunt ut labore et dolore
											magna aliqua. Ut enim ad minim veniam, quis nostrud
											exercitation</p>
									</div>
								</div>
							</div>
							<div class="carousel-item">
								<img class="d-block img-fluid"
									src="https://images.pexels.com/photos/7097/people-coffee-tea-meeting.jpg"
									alt="Second slide">
								<div class="carousel-caption d-none d-md-block">
									<div class="banner-text">
										<h2>This is Second Slide</h2>
										<p>Lorem ipsum dolor sit amet, consectetur adipiscing
											elit, sed do eiusmod tempor incididunt ut labore et dolore
											magna aliqua. Ut enim ad minim veniam, quis nostrud
											exercitation</p>
									</div>
								</div>
							</div>

						</div>

					</div>
				</div>
			</div>
		</div>
	</section>



</body>
</html>