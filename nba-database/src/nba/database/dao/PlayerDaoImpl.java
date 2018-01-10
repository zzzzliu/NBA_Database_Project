package nba.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import nba.database.entity.Player;
import nba.database.entity.PlayerCareerStats;
import nba.database.entity.PlayerSeasonStats;
import nba.database.entity.PlayerStatistics;
import nba.database.entity.PlayerStatisticsAGame;

@Repository
public class PlayerDaoImpl implements PlayerDao {

	public Connection conn;
	
	public PlayerDaoImpl() {
		this.conn = DBConnection.conn;
	}
	
	@SuppressWarnings("finally")
	@Override
	public List<Player> getPlayers(int seasonId) throws SQLException {
		List<Player> playerList = new ArrayList<>();
		PreparedStatement getPlayers = conn.prepareStatement("select t.name, p.*, pn.nationality, pp.position, s.name, "
				+ "c.salary, c.years, c.clause from Team t, Player p, Contract c, "
				+ "PlayerNationality pn, PlayerPosition pp, TeamSeasonStatistics ts, Season s "
				+ "where c.isEmployedBy = t.id and c.employs = p.id and ts.partOf = t.id and "
				+ "pp.player = p.id and pn.player = p.id and ts.season = s.id and ts.id = ?");
		try {	
			getPlayers.setInt(1, seasonId);
			ResultSet rs = getPlayers.executeQuery();		
			while (rs.next()) {
				String team = rs.getString(1);
				int id = rs.getInt(2);
				String name = rs.getString(3);
				String bornDate = rs.getString(4);
				double height = rs.getDouble(5);
				double weight = rs.getDouble(6);
				boolean hallOfFame = rs.getBoolean(7);
				String nationality = rs.getString(8);
				String position = rs.getString(9);				
				String season = rs.getString(10);
				int salary = rs.getInt(11);
				int years = rs.getInt(12);
				String clause = rs.getString(13);
				playerList.add(new Player(id, team, name, bornDate, height, weight, hallOfFame, 
						nationality, position, season, salary, years, clause));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if (getPlayers != null) getPlayers.close();
			return playerList;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public List<PlayerStatistics> getPlayerStats(int playerId) throws SQLException {
		List<PlayerStatistics> statsList = new ArrayList<>();

		PreparedStatement getStats = conn.prepareStatement("select s.name, p.name, pst.* "
				+ "from Player p, PlayerSeasonStatistics pst, Season s "
				+ "where pst.partOf = p.id and pst.season = s.id and p.id = ?");
		try {	
			getStats.setInt(1, playerId);
			ResultSet rs = getStats.executeQuery();		
			while (rs.next()) {
				String season = rs.getString(1);
				String name = rs.getString(2);

				int id = rs.getInt(3);
				double mp = rs.getDouble(4);
				double pts = rs.getDouble(5);
				double trb = rs.getDouble(6);
				double ast = rs.getDouble(7);
				double blk = rs.getDouble(8);
				double stl = rs.getDouble(9);
				double tov = rs.getDouble(10);
				double pf = rs.getDouble(11);
				double fg = rs.getDouble(12);
				double tp = rs.getDouble(13);
				double ft = rs.getDouble(14);
				double eff = rs.getDouble(15);
				double ws = rs.getDouble(16);
				double dws = rs.getDouble(17);
				double usg = rs.getDouble(18);
				statsList.add(new PlayerSeasonStats(season, playerId, mp, pts, trb, ast, blk, stl, tov,
						 pf, fg, tp, ft, eff, ws, dws, usg, name));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if (getStats != null) getStats.close();
			return statsList;
		}
	}
	
	@SuppressWarnings("finally")
	@Override
	public PlayerStatistics getCareerStats(int playerId) throws SQLException {
		PlayerStatistics stats = null;
		PreparedStatement getStats = conn.prepareStatement("select p.name, pct.* "
				+ "from Player p, PlayerCareerStatistics pct "
				+ "where pct.partOf = p.id and p.id = ?");
		try {	
			getStats.setInt(1, playerId);
			ResultSet rs = getStats.executeQuery();		
			while (rs.next()) {
				String name = rs.getString(1);
				int id = rs.getInt(2);
				double mp = rs.getDouble(3);
				double pts = rs.getDouble(4);
				double trb = rs.getDouble(5);
				double ast = rs.getDouble(6);
				double blk = rs.getDouble(7);
				double stl = rs.getDouble(8);
				double tov = rs.getDouble(9);
				double pf = rs.getDouble(10);
				double fg = rs.getDouble(11);
				double tp = rs.getDouble(12);
				double ft = rs.getDouble(13);
				double eff = rs.getDouble(14);
				double ws = rs.getDouble(15);
				double dws = rs.getDouble(16);
				double usg = rs.getDouble(17);
				stats = new PlayerCareerStats(id, mp, pts, trb, ast, blk, stl, tov,
						 pf, fg, tp, ft, eff, ws, dws, usg, name);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if (getStats != null) getStats.close();
			return stats;
		}
	}

	@SuppressWarnings({ "finally", "null" })
	@Override
	public List<PlayerStatisticsAGame> getPlayersStatsAGame(int playerId) throws SQLException {
		List<PlayerStatisticsAGame> stats = new ArrayList<>();
		PreparedStatement getStats = conn.prepareStatement("select p.name, g.gameDate, pl.minutes, psa.* "
				+ "from Player p, PlayerStatisticsAGame psa, play pl, Game g "
				+ "where p.id = pl.isPlayedBy and pl.plays = g.id "
				+ "and psa.partOfPlayer = pl.isPlayedBy and psa.partOfGame = pl.plays and p.id = ?");
		try {	
			getStats.setInt(1, playerId);
			ResultSet rs = getStats.executeQuery();		
			while (rs.next()) {
				String name = rs.getString(1);
				String date = rs.getString(2);
				double minutes = rs.getDouble(3);
				int id = rs.getInt(4);
				int pts = rs.getInt(5);
				int trb = rs.getInt(6);
				int ast = rs.getInt(7);
				int blk = rs.getInt(8);
				int stl = rs.getInt(9);
				int tov = rs.getInt(10);
				int pf = rs.getInt(11);
				double fg = rs.getDouble(12);
				double tp = rs.getDouble(13);
				double ft = rs.getDouble(14);
				stats.add(new PlayerStatisticsAGame(id, name, date, pts, trb, ast, blk, stl, tov,
						 pf, fg, tp, ft, minutes));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if (getStats != null) getStats.close();
			return stats;
		}
		
	}

		
}

