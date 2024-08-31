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
<link rel="stylesheet" href="userhome.css">
<title>User Home</title>
</head>
<body>
	<jsp:include page="user-navbar.jsp"></jsp:include>

	<!-- <div class="card" style="width: 18rem;">
		<div class="card-body">
			<h5 class="card-title">Card title</h5>
			<h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
			<p class="card-text">Some quick example text to build on the card
				title and make up the bulk of the card's content.</p>
			<a href="#" class="card-link">Card link</a> <a href="#"
				class="card-link">Another link</a>
		</div>
	</div> -->

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
				<a href="applyJob?id=<%=job.getId()%>"><button style="height: 30px;width: 135px;margin-bottom: 10px;background-color: blue; color: white; border-radius: 10px;">APPLY</button></a>
			</div>
		</div>
		<%}%>
	</div>


</body>
</html>