<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>post-job</title>
<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
	rel="stylesheet" />
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet" />
<!-- Font Awesome -->
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
<style type="text/css">
.gradient-custom-3 {
	/* fallback for old browsers */
	background: #84fab0;
	/* Chrome 10-25, Safari 5.1-6 */
	background: -webkit-linear-gradient(to right, rgba(132, 250, 176, 0.5),
		rgba(143, 211, 244, 0.5));
	/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
	background: linear-gradient(to right, rgba(132, 250, 176, 0.5),
		rgba(143, 211, 244, 0.5))
}

.gradient-custom-4 {
	/* fallback for old browsers */
	background: #84fab0;
	/* Chrome 10-25, Safari 5.1-6 */
	background: -webkit-linear-gradient(to right, rgba(132, 250, 176, 1),
		rgba(143, 211, 244, 1));
	/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
	background: linear-gradient(to right, rgba(132, 250, 176, 1),
		rgba(143, 211, 244, 1))
}
</style>
</head>
<body>
	<jsp:include page="recruiter-navbar.jsp"></jsp:include>
	<section class="vh-100 bg-image"
		style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">
		<div class="mask d-flex align-items-center h-100 gradient-custom-3">
			<div class="container h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-9 col-lg-7 col-xl-6">
						<div class="card" style="border-radius: 15px;">
							<div class="card-body p-5">
								<h2 class="text-uppercase text-center mb-5">Create-New-Job</h2>

								<form action="postJob" method="post">

									<div class="form-outline mb-4">
										<label class="form-label" for="form3Example1cg">Company
											Name:</label> <input type="text" id="form3Example1cg"
											class="form-control form-control-lg border" name="name" />
									</div>

									<div class="form-outline mb-4">
										<label class="form-label" for="form3Example3cg">Skills:</label>
										<input type="text" id="form3Example3cg"
											class="form-control form-control-lg border" name="skill" />
									</div>

									<div class="form-outline mb-4">
										<label class="form-label" for="form3Example4cg">Phone:</label>
										<input type="tel" id="form3Example4cg"
											class="form-control form-control-lg border" name="phone" />
									</div>

									<div class="form-outline mb-4">
										<label class="form-label" for="form3Example4cg">email:</label>
										<input type="email" id="form3Example4cg"
											class="form-control form-control-lg border" name="email" />
									</div>

									<div class="form-outline mb-4">
										<label class="form-label" for="form3Example4cdg">job
											title:</label> <input type="text" id="form3Example4cdg"
											class="form-control form-control-lg border" name="title" />
									</div>

									<div class="form-outline mb-4">
										<label class="form-label" for="form3Example4cdg">job
											location:</label> <input type="text" id="form3Example4cdg"
											class="form-control form-control-lg border" name="location" />
									</div>

									<div class="form-outline mb-4">
										<label class="form-label" for="form3Example4cdg">experience:
										</label> <input type="text" id="form3Example4cdg"
											class="form-control form-control-lg border" name="experience" />
									</div>
									
									<div class="form-outline mb-4">
										<label class="form-label" for="form3Example4cdg">job-role:
										</label> <input type="text" id="form3Example4cdg"
											class="form-control form-control-lg border" name="role" />
									</div>
									
									<div class="form-outline mb-4">
										<label class="form-label" for="form3Example4cdg">salary:
										</label> <input type="text" id="form3Example4cdg"
											class="form-control form-control-lg border" name="salary" />
									</div>

									<div class="form-outline mb-4">
										<label class="form-label" for="form3Example4cdg">Job-Description</label>
										<textarea type="text" id="form3Example4cdg"
											class="form-control form-control-lg border" name="description"></textarea>
									</div>
									<br>

									<div class="d-flex justify-content-center">
										<button type="submit"
											class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Post</button>
									</div>

								</form>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>