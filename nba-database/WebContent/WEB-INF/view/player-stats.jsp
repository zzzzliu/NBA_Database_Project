<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Player Stats</title>
	<!-- reference our style sheet -->
	<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Player Statistics</h2>
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
					<th>Name</th>
					<th>Season</th>
					<th>MP</th>
					<th>FG%</th>
					<th>3P%</th>
					<th>FT%</th>
					<th>TRB</th>
					<th>AST</th>
					<th>STL</th>
					<th>BLK</th>
					<th>TOV</th>
					<th>PF</th>
					<th>PTS</th>
					<th>PER</th>
					<th>WS</th>
					<th>DWS</th>
					<th>USG%</th>				
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers  -->
				<c:forEach var="tempStats" items="${playerStats}">
					
					<!-- construct an "teamSeason" link with customer id -->
					<c:url var="playerLink" value="/league/playerSeasons">
						<c:param name="playerId" value="${tempStats.id}" />
					</c:url>
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/league/updateTeam">
						<c:param name="statsId" value="${tempStats.id}" />
					</c:url>
						
					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/league/deleteTeam">
						<c:param name="statsId" value="${tempStats.id}" />
					</c:url>
					
					<tr>
						<td> 
							<a href="${playerLink}">${tempStats.name} </a>
						</td>
						<td>${tempStats.season}</td>
						<td> ${tempStats.minutesPerGame} </td>
						<td> ${tempStats.fieldGoalsPercentage} </td>
						<td> ${tempStats.threePointsPercentage} </td>
						<td> ${tempStats.freeThrowsPercentage} </td>
						<td> ${tempStats.reboundsPerGame} </td>
						<td> ${tempStats.assistsPerGame} </td>
						<td> ${tempStats.stealsPerGame} </td>
						<td> ${tempStats.blocksPerGame} </td>
						<td> ${tempStats.turnoversPerGame} </td>
						<td> ${tempStats.foulsPerGame} </td>
						<td> ${tempStats.pointsPerGame} </td>
						<td> ${tempStats.efficiencyRating} </td>
						<td> ${tempStats.winShares} </td>
						<td> ${tempStats.defensiveWinShares} </td>
						<td> ${tempStats.usageRate} </td>

						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
								onclick="if(!(confirm('Are you sure you want to delete theis season?'))) return false">Delete</a>
						</td>
						
						
					</tr>
				</c:forEach>
			</table>
		
		</div>
	</div>
</body>


</html>