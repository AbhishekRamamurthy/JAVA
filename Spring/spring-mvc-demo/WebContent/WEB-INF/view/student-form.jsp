<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<title>Student Registration Page</title>
</head>

<body>
	<form:form action="processForm" modelAttribute="student">
	
	First Name: <form:input path="firstName"/>
	
	<br><br>
	
	Last Name: <form:input path="lastName"/>
	<br><br>
	Country:
	<form:select path="country">
		<form:options items = "${student.countryOptions}"/>
	<!--  
		<form:option value="Brazil" label="Brazil"/>
		<form:option value="France" label="France"/>
		<form:option value="Germany" label="Germany"/>
		<form:option value="India" label="India"/>
	-->
	</form:select> 
	<br><br>
	
	Favorite Language:
	JAVA <form:radiobutton path="favoriteLanguage" value = "JAVA"/>
	C# <form:radiobutton path="favoriteLanguage" value = "C#"/>
	PHP <form:radiobutton path="favoriteLanguage" value = "PHP"/>
	RUBY <form:radiobutton path="favoriteLanguage" value = "RUBY"/>
	<br><br>
	
	Operating Systems:
	Linux <form:checkbox path="operatingSystems" value="Linux"/>
	MAC <form:checkbox path="operatingSystems" value="MAC"/>
	WINDOWS <form:checkbox path="operatingSystems" value="WINDOWS"/>
	
	<br><br>
	<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>