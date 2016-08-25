<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Firearms Inventory App</title>

<link type="text/css" rel="stylesheet" href="css/style.css">

<script type="text/javascript" src="js/jquery-3.1.0.slim.js"></script> 
<script type="text/javascript" src="js/jquery.tablesorter.js"></script> 

<script>
	$(document).ready(
		function() 
    	{ 
        	$("#myTable").tablesorter(); 
    	}
	)
</script> 
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Firearms Inventory with Sortable Table</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">

			<input type="button" value="Add Firearm"
				onclick="window.location.href='view-firearm.jsp'; return false"
				class="add-firearm-button" /> <input type="button"
				value="Search Firearm"
				onclick="window.location.href='search-firearm.jsp'; return false"
				class="add-firearm-button" />

			<table id="myTable" class="tablesorter">
				<thead>
				<tr>
					<th>Serial Number</th>
					<th>Model</th>
					<th>Make</th>
					<th>Type</th>
					<th>Caliber</th>
					<th>Date Purchased</th>
					<th>Notes</th>
					<th></th>
				</tr>
				</thead>

				<c:forEach var="firearm" items="${FIREARM_LIST}">

					<!-- Link for updating student -->
					<c:url var="tempLink" value="FirearmsInventoryControllerServlet">
						<c:param name="command" value="VIEW" />
						<c:param name="serialNumber" value="${firearm.serialNumber}" />
					</c:url>

					<!-- Link for deleting student -->
					<c:url var="deleteLink" value="FirearmsInventoryControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="serialNumber" value="${firearm.serialNumber}" />
					</c:url>

					<tr>
						<td><a href="${tempLink}">${firearm.serialNumber}</a></td>
						<td>${firearm.model}</td>
						<td>${firearm.make}</td>
						<td>${firearm.type}</td>
						<td>${firearm.caliber}</td>
						<td>${firearm.datePurchased}</td>
						<td>${firearm.notes}</td>
						<td><a href="${tempLink}">Update</a> | <a
							href="${deleteLink}"
							onclick="if(!(confirm('Are you sure you want to delete this firearm?'))) return false">Delete</a>
						</td>
					</tr>

				</c:forEach>

			</table>
		</div>
	</div>
</body>
</html>