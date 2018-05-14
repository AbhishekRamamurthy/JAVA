<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<title>List Customers</title>
	<!-- style sheet -->
	<link type="text/csss" rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<input type="button" value = "Add Customer"
					onclick="window.location.href='showFormForAdd;return false;'"
					class="add-button"/>
			
			<form:form action ="search" method="POST">
				Search Customer: <input type="text" name="theSearchName"/>
				<input type="submit" value="Search" class="add-button"/>
			</form:form>
			
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<!-- loop over and print customer -->
				<c:forEach var="tempCustomers" items="${customers }">
					
					<!-- construct an update linke with customer id -->
					<c:url var ="updateLink" value="/customer/showFormForUpdate">
						<c:param name = "customerId" value="${tempCustomers.id}"/>
					</c:url>
					
					<c:url var ="deleteLink" value="/customer/delete">
						<c:param name = "customerId" value="${tempCustomers.id}"/>
					</c:url>
					
					<tr>
						<td>${tempCustomers.firstName}</td>
						<td>${tempCustomers.lastName}</td>
						<td>${tempCustomers.email}</td>
						
						<td>
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick= "if(!(confirm('Are sure you want to delete')))return false">Delete</a>
						</td>
						
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>