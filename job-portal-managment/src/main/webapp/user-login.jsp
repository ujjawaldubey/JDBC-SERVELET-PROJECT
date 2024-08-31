<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form Page</title>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
	rel="stylesheet" />
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet" />
<!-- MDB -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.1.0/mdb.min.css"
	rel="stylesheet" />

<link rel="stylesheet" href="user-login.css" />

</head>
</head>
<body>

	<%
	String emailIncorercct = (String) request.getAttribute("emailWrong");
	String passwordIncorrect = (String) request.getAttribute("passwordWrong");
	String logoutMessage = (String) request.getAttribute("logoutMsg");
	String sessionLogout = (String) request.getAttribute("sessionLogout");
	%>



	<!-- user login page -->
	<!-- sjdgukdsbnljv -->
	<section class="h-100 gradient-form" style="background-color: #eee;">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-xl-10">
					<div class="card rounded-3 text-black">
						<div class="row g-0">
							<div class="col-lg-6 d-flex align-items-center gradient-custom-2">
								<div class="text-white px-3 py-4 p-md-5 mx-md-4">
									<h4 class="mb-4">We Provide Excellent Training</h4>
									<p class="small mb-0">We make your future brighter after
										completion of full stack java course</p>
								</div>
							</div>


							<div class="col-lg-6">
								<div class="card-body p-md-5 mx-md-4">

									<div class="text-center" >
										<img style="border-radius: 50%; background-color: red"
											src="https://media.licdn.com/dms/image/C560BAQEVqtIX4bs1RA/company-logo_200_200/0/1672744977770/jspiders___training__development_center_logo?e=2147483647&v=beta&t=Eax0yj68G4iXikx6uDcYUPguesxVU9ZpPV8eZOJvI7w"
											 alt="logo">
										<h4 class="mt-1 mb-5 pb-1">We are Developer From JSpider</h4>
									</div>

									<%
									if (logoutMessage != null) {
									%>
									<p style="color: green;"><%=logoutMessage%></p>
									<%
									}
									%>
									
									<%
									if (sessionLogout != null) {
									%>
									<p style="color: green;"><%=sessionLogout%></p>
									<%
									}
									%>

									<form action="userlogin" method="post">
										<p>Please login to your account</p>
										<%
										if (emailIncorercct != null) {
										%>
										<p style="color: red"><%=emailIncorercct%></p>
										<%
										}
										%>
										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example11">Username</label>
											<input type="email" id="form2Example11" class="form-control border"
												placeholder="Phone number or email address" name="username" />
											
										</div>
										<%
										if (passwordIncorrect != null) {
										%>
										<p style="color: red"><%=passwordIncorrect%></p>
										<%
										}
										%>
										<div class="form-outline mb-4">
											<label
												class="form-label " for="form2Example22">Password</label>
											<input type="password" id="form2Example22"
												class="form-control border" name="password" /> 
										</div>

										<!-- radio button -->

										<div class="form-check form-check-inline">
											<input class="form-check-input" type="radio" name="login"
												id="inlineRadio1" value="user" /> <label
												class="form-check-label" for="inlineRadio1">user</label>
										</div>

										<div class="form-check form-check-inline">
											<input class="form-check-input" type="radio" name="login"
												id="inlineRadio2" value="recruiter" /> <label
												class="form-check-label" for="inlineRadio2">recruiter</label>
										</div>

										<div class="form-check form-check-inline">
											<input class="form-check-input" type="radio" name="login"
												id="inlineRadio3" value="admin" /> <label
												class="form-check-label" for="inlineRadio3">admin </label>
										</div>
										

										<!-- radio button end -->

										<div class="text-center pt-1 mb-5 pb-1">
											<button
												class="btn btn-primary btn-block fa-lg gradient-custom-2 mb-3"
												type="submit">Log in</button>
											<a class="text-muted" href="#!">Forgot password?</a>
										</div>


										<div
											class="d-flex align-items-center justify-content-center pb-4">
											<p class="mb-0 me-2">Don't have an account?</p>
											<a href="user-registration.jsp">
												<button type="button" class="btn btn-outline-danger">Register
													Now</button>
											</a>
										</div>
									</form>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="dropdown.js">
		
	</script>
</body>
</html>