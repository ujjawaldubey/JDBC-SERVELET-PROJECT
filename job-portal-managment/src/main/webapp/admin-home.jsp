<%@page import="com.jsp.job_portal_management.dto.PostJob"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.job_portal_management.dao.GetJobDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

table, th, td {
	border: 1px solid #ddd;
}

th, td {
	padding: 12px;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}
</style>
</head>
<body>
	<%
	GetJobDetails details = new GetJobDetails();

	List<PostJob> jobs = details.getAllPostedJobDetailsDao();
	%>
	<jsp:include page="admin-navbar.jsp"></jsp:include>
	<br><br>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Title</th>
				<th>Location</th>
				<th>Experience</th>
				<th>Description</th>
				<th>Skill</th>
				<th>Role</th>
				<th>Salary</th>
				<th>Verified</th>
			</tr>
		</thead>
		<%
		for (PostJob job : jobs) {
		%>
		<tbody>
			<!-- You will need to iterate over your ResultSet and create rows dynamically -->
			<tr>
				<td><%=job.getId()%></td>
				<td><%=job.getName()%></td>
				<td><%=job.getEmail()%></td>
				<td><%=job.getPhone()%></td>
				<td><%=job.getTitle()%></td>
				<td><%=job.getLocation()%></td>
				<td><%=job.getExperience()%></td>
				<td><%=job.getDescription()%></td>
				<td><%=job.getSkills()%></td>
				<td><%=job.getRole()%></td>
				<td><%=job.getSalary()%></td>
				<td><a href="verify?id=<%=job.getId()%>"><button
							style="border: none;">
							<%
							if (job.getVerify().equalsIgnoreCase("yes")) {
							%><span
								style="color: green;">verified<span>
									<%
									} else {
									%><span style="color: red;">verify-it<span>
											<%
											}
											%>
									
						</button></a></td>
			</tr>
			<!-- Repeat the above row for each record in your ResultSet -->
		</tbody>
		<%
		}
		%>
	</table>

</body>
</html>