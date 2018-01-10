<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Team Players</title>
	<!-- reference our style sheet -->
	<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Team Players List</h2>
		</div>
	</div>
	
	<div id="container">
		
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Add Season"
					onclick="window.location.href='addTeamSeason'; return false"
					class="add-button"
				/>
		
			<!-- add our html table here -->
		
			<table>
				<tr>				
					<th>Season</th>
					<th>Team</th>
					<th>Name</th>
					<th>Born</th>
					<th>Nationality</th>
					<th>Height/CM</th>
					<th>Weight/KG</th>
					<th>Position</th>
					<th>Contact Year</th>
					<th>Salary</th>
					<th>Clause</th>
					<th>Hall of Fame</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers  -->
				<c:forEach var="tempPlayer" items="${teamPlayers}">
					
					<!-- construct an "teamSeason" link with customer id -->
					<c:url var="playerLink" value="/league/players">
						<c:param name="playerId" value="${tempPlayer.id}" />
					</c:url>
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/league/updateTeam">
						<c:param name="playerId" value="${tempPlayer.id}" />
					</c:url>
						
					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/league/deleteTeam">
						<c:param name="playerId" value="${tempPlayer.id}" />
					</c:url>
					
					<tr>
						<td> ${tempPlayer.season} </td>
						<td> ${tempPlayer.team} </td>
						<td> 
							<a href="${playerLink}">${tempPlayer.name}</a>
						</td>
						<td> ${tempPlayer.bornDate} </td>
						<td> ${tempPlayer.nationality} </td>
						<td> ${tempPlayer.height} </td>
						<td> ${tempPlayer.weight} </td>
						<td> ${tempPlayer.position} </td>
						<td> ${tempPlayer.years} </td>
						<td> ${tempPlayer.salary} </td>
						<td> ${tempPlayer.clause} </td>
						<td> ${tempPlayer.hallOfFame} </td>
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
								onclick="if(!(confirm('Are you sure you want to delete theis player?'))) return false">Delete</a>
						</td>
						
						
					</tr>
				</c:forEach>
			</table>
		
		</div>
	
	</div>

</body>


</html>