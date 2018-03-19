<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="Model.Competition"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Competition List</title>
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
<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTncVt5ufwn8ULGoHezHKtYppBiAAt0QowYTi6wYhvnX1p0LK_S7g"> 
<h2>View All Competitions</h2>
<form method = "post" action = "AlterCompetitionServlet">
		<table>
		<tr>  
			<th>Competition Name</th>
			<th>Band ID</th> 
		</tr>
			<c:forEach items="${requestScope.allItems}" var="currentitem">
				<tr>
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