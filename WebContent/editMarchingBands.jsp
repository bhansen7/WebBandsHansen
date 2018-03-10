<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table, td, th {
	border: 1px solid black;
	border-collapse: separate;
	border-spacing: 2px;
	padding: 2px;
}
</style>
</head>
<body>
	<form action="EditMarchingBandServlet" method="post">

		Name of Band: <input type="text" name="name of band" value="${bandToEdit.nameOfBand }"><br />
		Number of Members: <input type="text" name="number of members" value="${bandToEdit.numberOfMembers }"><br />
		Location of Band: <input type="text" name="location of band" value="${bandToEdit.locationOfBand }"><br />
		Level of Band: <select name="level of band">
			<option value=1>Elementary</option>
			<option value=2>Junior High</option>
			<option value=3>High School</option>
			value="${bandToEdit.levelBandId}"
		</select><br /> 
		Types of props (may leave blank)? <input type="text"
			name="Type of Props" value="${bandToEdit.typesOfProps}"><br /> 
		Color guard: <select
			name="Has colorguard">
			<option value=yes>Yes</option>
			<option value=no>No</option>
			value="${bandToEdit.hasColorGuard}"
		</select><br /> 
		<input type="hidden" name="bandId"
			value="${bandToEdit.bandId }"> <input type="submit"
			value="Save Edited Band">
	</form>
</body>
</html>