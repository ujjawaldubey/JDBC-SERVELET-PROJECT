<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jsp.job_portal_management.dto.PostJob"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.job_portal_management.dao.PostJobDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Job Portal By Mo Masood Ansari</title>
<link rel="stylesheet" href="userhome.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">JobDekho</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
				aria-controls="navbarNavDropdown" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavDropdown">
				<ul class="navbar-nav">


					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Jobs </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
							<li><a class="dropdown-item" href="#">SOFTWARE DEVLOPER</a></li>
							<li><a class="dropdown-item" href="#">SOFTWARE TESTER</a></li>
							<li><a class="dropdown-item" href="#">SOFTWARE SUPORT</a></li>
						</ul></li>
				</ul>

				<ul class="navbar-nav">

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Companies </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
							<li><a class="dropdown-item" href="#">Product Base</a></li>
							<li><a class="dropdown-item" href="#">Service Base</a></li>

						</ul></li>
				</ul>
			</div>
		</div>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">

				<li class="nav-item"><a class="nav-link" href="user-login.jsp">Login</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">|</a></li>

				<ul class="navbar-nav">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> register </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink"
							style="margin-right: 20px;">
							<li><a class="dropdown-item" href="user-registration.jsp">for-user</a></li>
							<li><a class="dropdown-item"
								href="recruiter-registration.jsp">for-recruiter</a></li>
						</ul></li>
				</ul>
			</ul>
		</div>

	</nav>


	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search...">

					<div class="input-group-append">
						<button class="btn btn-success" type="button">Search</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%
	PostJobDao dao = new PostJobDao();
	List<PostJob> jobs = dao.getAllVerifiedJobDao();
	%>

	<div class="container " style="margin-top: 10%">
		<%
		for (PostJob job : jobs) {
		%>
		<%
		String skills = job.getSkills();
		List<String> strings = new ArrayList<String>(Arrays.asList(skills.split(",")));
		%>
		<div class="card">
			<div class="inner-card" style="border: 1px solid red">
				<div>
					<div>
						<h3><%=job.getTitle()%></h3>
					</div>
					<div>
						<p><%=job.getName()%></p>
					</div>
					<div class="list">
						<ul>
							<li><i class="fa-solid fa-suitcase"></i><%=job.getExperience()%></li>
							<li>|</li>
							<li><i class="fa-solid fa-indian-rupee-sign"></i><%=job.getSalary()%></li>
							<li>|</i></li>
							<li><i class="fa-sharp fa-solid fa-location-dot"></i><%=job.getLocation()%></li>
						</ul>
					</div>
					<div class="disc"><%=job.getDescription()%></div>
					<div class="list">
						<ul>
							<%
							for (String string : strings) {
							%>
							<li><%=string%></li>
							<li>|</li>
							<%
							}
							%>
						</ul>
					</div>
				</div>
			</div>
			<div>
				<a href="applyJob?id=<%=job.getId()%>"><button
						style="height: 30px; width: 135px; margin-bottom: 10px; background-color: blue; color: white; border-radius: 10px;">APPLY</button></a>
			</div>
		</div>
		<%
		}
		%>
	</div>







	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>