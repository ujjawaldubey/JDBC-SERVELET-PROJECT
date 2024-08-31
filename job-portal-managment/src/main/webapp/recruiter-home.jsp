<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>recruiter-home</title>
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
</head>
<body>
		<jsp:include page="recruiter-navbar.jsp"></jsp:include>
		<br><br>
		<h3 style="display: flex; justify-content: center; align-items: center; color: maroon; margin-top: 10px;">Job-Applied-By-User</h3>
	<table>
		<thead>
			<tr>
				<th>User-ID</th>
				<th>User-Name</th>
				<th>User-Email</th>
				<th>User-Phone</th>
				<th>User-Education</th>
				<th>User-Current-Location</th>
				<th>User-Permanent-Location</th>
				<th>Job-Title</th>
				<th>Job-Location</th>
				<th>Job-Experience</th>
				<th>Job-Description</th>
				<th>Job-Skill</th>
				<th>Job-Role</th>
				<th>Job-Salary</th>
			</tr>
		</thead>
		<%
		%>
		<tbody>
			<!-- You will need to iterate over your ResultSet and create rows dynamically -->
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
		<%
		%>
	</table>
		
</body>
</html>