<%@page import="com.jsp.job_portal_management.dto.UserProfile"%>
<%@page import="com.jsp.job_portal_management.dao.UserProfileDao"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="com.jsp.job_portal_management.dto.User"%>
<%@page import="com.jsp.job_portal_management.dao.UserDao"%>
<%@ page import="org.apache.commons.io.IOUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
{
box-sizing
:border-box
;


}

/* Button used to open the contact form - fixed at the bottom of the page */
/* .open-button {
	background-color: #555;
	color: white;
	padding: 16px 20px;
	border: none;
	cursor: pointer;
	opacity: 0.8;
	position: fixed;
	bottom: 23px;
	right: 28px;
	width: 280px;
} */

/* The popup form - hidden by default */
.form-popup {
	display: none;
	bottom: 15%;
	border: 3px solid #f1f1f1;
	z-index: 9;
}

/* Add styles to the form container */
.form-container {
	max-width: 250px;
	padding: 10px;
	background-color: white;
}

/* Full-width input fields */
.form-container input[type=text], .form-container input[type=password] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	border: none;
	background: #f1f1f1;
}

/* When the inputs get focus, do something */
.form-container input[type=text]:focus, .form-container input[type=password]:focus
	{
	background-color: #ddd;
	outline: none;
}

/* Set a style for the submit/login button */
.form-container .btn {
	background-color: #04AA6D;
	color: white;
	padding: 10px 10px;
	border: none;
	border-radius : 20px;
	cursor: pointer;
	width: 100%;
	margin-bottom: 10px;
	opacity: 0.8;
	margin:10px;
}

/* Add a red background color to the cancel button */
.form-container .cancel {
	background-color: red;
}

/* Add some hover effects to buttons */
.form-container .btn:hover, .open-button:hover {
	opacity: 1;
}
</style>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Details</title>
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

<link rel="stylesheet" src="user-profile.css" />
</head>
<body>

	<jsp:include page="user-navbar.jsp"></jsp:include>

	<%
	/* ServletOutputStream outputStream = response.getOutputStream();*/
	User user = (User) request.getAttribute("userDetails");
	%>
	<%
	UserProfileDao dao = new UserProfileDao();
	UserProfile profile = dao.getUserProfileByUserIdDao(user.getId());
	%>
	<%!// Function to convert InputStream to Base64 String
	private String getBase64Image(InputStream imageStream) {
		try {
			byte[] bytes = IOUtils.toByteArray(imageStream);
			return java.util.Base64.getEncoder().encodeToString(bytes);
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}%>

	<div class="container rounded bg-white mt-5 mb-5">
		<div class="row">
			<div class="col-md-3 border-right">
				<div
					class="d-flex flex-column align-items-center text-center p-3 py-5">
					<img class="rounded-circle mt-5" width="150px"
						src="data:image/jpeg;base64,<%=getBase64Image(user.getImage())%>"><span
						class="font-weight-bold"><%=user.getName()%></span><span
						class="text-black-50"><%=user.getEmail()%></span><span> </span>
					<!-- image change button -->
					<button onclick="openForm()">change-profile-image</button>

					<!-- profile change code -->

					<div class="form-popup" id="myForm">
						<form action="updateProfileImage" class="form-container"
							method="post" enctype="multipart/form-data">
							<input type="file" name="image"> <input type="email"
								name="email" value="<%=user.getEmail()%>" hidden="true">

							<button type="submit" class="btn">Update-Profile-Image</button>
							<button type="button" class="btn cancel" onclick="closeForm()">Close</button>
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-5 border-right">
				<div class="p-3 py-5">
					<div class="d-flex justify-content-between align-items-center mb-3">
						<h4 class="text-right">Profile-Settings:</h4>
					</div>
					<form action="updateUserProfile" method="post">
						<div class="row mt-2">
							<div class="col-md-6">
								<label class="labels">Full-Name:</label><input type="text"
									class="form-control" placeholder="first name" name="name"
									value="<%=user.getName()%>">
							</div>
						</div>
						<div class="row mt-3">
							<div class="col-md-12">
								<label class="labels">Mobile-Number:</label><input type="text"
									class="form-control" placeholder="enter phone number"
									name="phone" value="<%=user.getPhone()%>">
							</div>
							<div class="col-md-12">
								<label class="labels">Current-Address:</label><input type="text"
									class="form-control" placeholder="enter current address"
									value="<%=profile.getCurrentAddress()%>" name="current">
							</div>
							<div class="col-md-12">
								<label class="labels">Permanent-Address:</label><input
									type="text" class="form-control"
									placeholder="enter permanent address"
									value="<%=profile.getPermanentAddress()%>" name="permanent">
							</div>
							<div class="col-md-12">
								<label class="labels">Pincode:</label><input type="text"
									class="form-control" placeholder="enter pin-code"
									value="<%=profile.getPincode()%>" name="pincode">
							</div>
							<div class="col-md-12">
								<label class="labels">City:</label><input type="text"
									class="form-control" placeholder="enter your city"
									value="<%=profile.getCity()%>" name="city">
							</div>
							<div class="col-md-12">
								<label class="labels">Email-ID:</label><input type="email"
									class="form-control" placeholder="enter email id"
									value="<%=user.getEmail()%>" name="email">
							</div>
							<div class="col-md-12">
								<label class="labels">Education:</label><input type="text"
									class="form-control" placeholder="highest-Qualification-Branch"
									value="<%=profile.getEducation()%>" name="education">
							</div>
						</div>
						<div class="row mt-3">
							<div class="col-md-6">
								<label class="labels">Country:</label><input type="text"
									class="form-control" placeholder="country"
									value="<%=profile.getCountry()%>" name="country">
							</div>
							<div class="col-md-6">
								<label class="labels">State/Region:</label><input type="text"
									class="form-control" value="<%=profile.getState()%>"
									placeholder="state" name="state">
							</div>
						</div>
						<div class="mt-5 text-center">
							<button class="btn btn-primary profile-button" type="submit">Save
								Profile</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	</div>
	</div>
	</div>

	<script type="text/javascript">
		function openForm() {
			document.getElementById("myForm").style.display = "block";
		}

		function closeForm() {
			document.getElementById("myForm").style.display = "none";
		}
	</script>
</body>
</html>