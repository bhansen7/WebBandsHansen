<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="Model.Bands"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table, td, th {
	border: 1px solid balck;
	border-collapse: separate;
	border-spacing: 2px;
	padding: 2px;
}
</style>
</head>
<body>
<form method = "post" action = "AlterMarchingBandServlet">
		<table>
		<tr>
			<th>Band ID</th>
			<th>Name of Band</th>
			<th>Number of Members</th>
			<th>Location of Band</th>
			<th>Cost of Participation</th>
			<th>Level of Band</th>
			<th>Type of Props</th>
			<th>Number of Buses</th>
			<th>Color Guard?</th>
			
		</tr>
			<c:forEach items="${requestScope.allItems}" var="currentitem">
				<tr>
					<td><input type="radio" name="bandId" value="${currentitem.bandId}"></td>
					<td>${currentitem.nameOfBand}</td>
					<td>${currentitem.numberOfMembers}</td>
					<td>${currentitem.locationOfBand}</td>
					<td>${currentitem.costOfParticipation}</td>
					<td>${currentitem.getLevelOfBand()}</td>	
					<td>${currentitem.typesOfProps}</td>	
					<td>${currentitem.numberOfBuses}</td>
					<td>${currentitem.hasColorGuard}</td>		
				</tr>
			</c:forEach>
		</table>
		<input type = "submit" value = "Edit Selected Band" name = "doThisToBand">
		<input type = "submit" value = "Delete Selected Band" name = "doThisToBand">
		<input type = "submit" value = "Add New Band" name = "doThisToBand">
	</form> 
	<a href ="index.html"> Back to Main Menu</a><br />
	
</body>
</html>