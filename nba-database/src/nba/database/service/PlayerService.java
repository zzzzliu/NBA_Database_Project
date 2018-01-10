package nba.database.service;

import java.sql.SQLException;
import java.util.List;

import nba.database.entity.Player;
import nba.database.entity.PlayerStatistics;
import nba.database.entity.PlayerStatisticsAGame;

public interface PlayerService {

	List<Player> getPlayers(int seasonId) throws SQLException;

	List<PlayerStatistics> getPlayerStats(int playerId) throws SQLException;

	List<PlayerStatisticsAGame> getPlayerStatsAGame(int playerId) throws SQLException;
}
