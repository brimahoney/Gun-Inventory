<!DOCTYPE html>
<html>
<head>
	<title>View Firearm</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/view-firearm-style.css">
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Firearm Inventory</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>View Firearm</h3>
	
		<form action="FirearmInventoryControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />
			
			<input type="hidden" name="serialNumber" value="${FIREARM.serialNumber}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Model:</label></td>
						<td><input type="text" name="model" 
									value="${FIREARM.model}"/></td>
					</tr>
					
					<tr>
						<td><label>Make:</label></td>
						<td><input type="text" name="make" 
									value="${FIREARM.make}"/></td>
					</tr>
					
					<tr>
						<td><label>Type:</label></td>
						<td><input type="text" name="type" 
									value="${FIREARM.type}"/></td>
					</tr>

					<tr>
						<td><label>Caliber:</label></td>
						<td><input type="text" name="caliber" 
									value="${FIREARM.caliber}"/></td>
					</tr>
					
					<tr>
						<td><label>Date Purchased:</label></td>
						<td><input type="text" name="datePurchased" 
									value="${FIREARM.datePurchased}"/></td>
					</tr>
					
					<tr>
						<td><label>Notes:</label></td>
						<td>
							<textarea rows="4" cols="30" name="notes">
							${FIREARM.notes}
							</textarea>
						</td>
					</tr>										
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>  
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="FirearmsInventoryControllerServlet">Back to Inventory</a>
		</p> 
	</div>

</body>
</html>