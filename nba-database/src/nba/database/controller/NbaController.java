package nba.database.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import nba.database.entity.Player;
import nba.database.entity.PlayerStatistics;
import nba.database.entity.PlayerStatisticsAGame;
import nba.database.entity.Team;
import nba.database.entity.TeamSeasonStatistics;
import nba.database.entity.TeamStatisticsAGame;
import nba.database.service.PlayerService;
import nba.database.service.TeamService;

@Controller
@RequestMapping("/league")
public class NbaController {

	@Autowired
	private TeamService teamService;
	@Autowired
	private PlayerService playerService;
	
	@GetMapping("/mainPages")
	public String showPage() {
		return "main-menu";
	}
	
	@GetMapping("/showTeams")
	public String showTeams(Model theModel) throws Exception {
		
		List<Team> theTeams = teamService.getTeams();
		
		theModel.addAttribute("teams", theTeams);
		
		return "teams-page";
	}
	
	@GetMapping("/teamSeasons")
	public String showTeamSeasons(@RequestParam("teamId") int theId, 
			Model theModel) throws Exception {
		List<TeamSeasonStatistics> seasons = teamService.getSeasonStats(theId);
		theModel.addAttribute("teamSeasons", seasons);
		return "team-seasons";
	}
	
	@GetMapping("/teamPlayers")
	public String showTeamPlayers(@RequestParam("seasonId") int seasonId, 
			Model theModel) throws Exception {
		List<Player> players = playerService.getPlayers(seasonId);
		theModel.addAttribute("teamPlayers", players);		
		return "team-players";
	}
	
	@GetMapping("/players")
	public String showPlayerStats (@RequestParam("playerId") int playerId, 
			Model theModel) throws Exception {
		List<PlayerStatistics> playerStats = playerService.getPlayerStats(playerId);
		theModel.addAttribute("playerStats", playerStats);		
		return "player-stats";		
	}
	
	@GetMapping("/playerSeasons")
	public String showPlayerSeasons (@RequestParam("playerId") int playerId,
			Model theModel) throws Exception {
		List<PlayerStatisticsAGame> aGameStats = playerService.getPlayerStatsAGame(playerId);
		theModel.addAttribute("playerStatsAGame", aGameStats);		

		return "player-stats-aGame";
	}
	@GetMapping("/teamStatsAGame")
	public String showTeamStatsAGame (@RequestParam("teamName") String teamName,
			Model theModel) throws Exception {
		List<TeamStatisticsAGame> aGameStats = teamService.getTeamStatsAGame(teamName);
		theModel.addAttribute("teamStatsAGame", aGameStats);		

		return "team-stats-aGame";
	}
	
	@GetMapping("/teamFormForAdd")
	public String teamFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		TeamStatisticsAGame theStats = new TeamStatisticsAGame();
		
		theModel.addAttribute("teamStats", theStats);
		
		return "team-form";
	}
	@PostMapping("/teamFormForUpdate")
	public String teamFormForUpdate(@ModelAttribute("statsId") int statsId, 
			Model theModel) throws SQLException {
		
		// save the customer using our service
		TeamStatisticsAGame stats = teamService.getTeamStatisticsAGame(statsId);
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("stats", stats);
		
		return "team-form";
	}
	
	@PostMapping("/saveForTeamStats")
	public String saveForTeamStats(@ModelAttribute("teamStats") TeamStatisticsAGame stats) throws SQLException {
		
		// save the customer using our service
		teamService.saveTeamStats(stats);
		
		return "redirect:/league/showTeams";
	}
}
