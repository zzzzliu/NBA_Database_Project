package nba.database.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nba.database.dao.PlayerDao;
import nba.database.entity.Player;
import nba.database.entity.PlayerStatistics;
import nba.database.entity.PlayerStatisticsAGame;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerDao playerDao;
	@Override
	public List<Player> getPlayers(int seasonId) throws SQLException {

		return playerDao.getPlayers(seasonId);
	}
	@Override
	public List<PlayerStatistics> getPlayerStats(int playerId) throws SQLException {

		List<PlayerStatistics> list = playerDao.getPlayerStats(playerId);
		list.add(playerDao.getCareerStats(playerId));
		return list;
	}
	@Override
	public List<PlayerStatisticsAGame> getPlayerStatsAGame(int playerId) throws SQLException {
		
		return playerDao.getPlayersStatsAGame(playerId);
	}

}
