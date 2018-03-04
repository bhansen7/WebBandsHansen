<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="EditPepBandServlet" method="post">
		Band Name: <input type="text" name="name of band"
			value="${bandToEdit.nameOfBand }"> 
		Event ID: <input type="text" name="Event Id"
			value="${bandToEdit.eventId }">  
		<input type="hidden"
			name="bandId" value="${bandToEdit.bandId }">
		 <input type="submit" value="Save Edited Band">
	</form>
</body>
</html>