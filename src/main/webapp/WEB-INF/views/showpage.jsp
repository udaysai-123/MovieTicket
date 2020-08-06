<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
	background-color: skyblue;
}

h2 {
	color: blue;
	text-align: center;
}

table {
	margin-left: auto;
	margin-right: auto;
	color: navy;
}
</style>
<body>
	<h2>Movie Ticket Booking</h2>
	<form:form action="calculateCost" method="post" modelAttribute="ticket">
		<table>
			<tr>
				<td>Movie Name</td>
				<td><form:input id="movieName" name="movieName"
						path="movieName" /></td>
			<tr>
				<td>Choose Circle</td>
				<td><form:select path="circleType">
						<c:forEach items="${circleList}" var="entry">
							<option>${entry.key}</option>
						</c:forEach>
					</form:select></td>
			<tr>
				<td>Number Of Tickets</td>
				<td><form:input type="nomber" id="noOfTickets"
						name="noOfTickets" path="noOfTickets" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Calculate Cost" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>