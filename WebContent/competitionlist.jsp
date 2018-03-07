<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="Model.Competition"%>
<%@ page import="Model.Bands"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Competition List</title>
</head>
<body>
<form method = "post" action = "AlterCompetitionServlet">
		<table>
		<tr> 
			<th> </th>
			<th>Competition ID</th>
			<th>Band ID</th> 
		</tr>
			<c:forEach items="${requestScope.allItems}" var="currentitem">
				<tr>
					<td><input type="radio" name="competitionId" value="${currentitem.competitionId}"></td>
					<td>${currentitem.getCompetitionName()}</td>
					<td>${currentitem.bandId}</td> 
				</tr>
			</c:forEach>
		</table>  
		<input type = "submit" value = "Add Band to Competition" name = "doThisToCompetition">
	</form> 
<a href ="index.html"> Back to Main Menu</a><br />

</body>
</html>