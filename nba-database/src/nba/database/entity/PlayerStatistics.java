package nba.database.entity;

public abstract class PlayerStatistics {

	private int id;
	private String name;
	private String season;
	private double minutesPerGame;
	private double pointsPerGame;
	private double reboundsPerGame;
	private double assistsPerGame;
	private double blocksPerGame;
	private double stealsPerGame;
	private double turnoversPerGame;
	private double foulsPerGame;
	private double fieldGoalsPercentage;
	private double threePointsPercentage;
	private double freeThrowsPercentage;
	private double efficiencyRating;
	private double winShares;
	private double defensiveWinShares;
	private double usageRate;
	
	
	
	public PlayerStatistics(int id2, double minutesPerGame, double pointsPerGame, double reboundsPerGame,
			double assistsPerGame, double blocksPerGame, double stealsPerGame, double turnoversPerGame,
			double foulsPerGame, double fieldGoalsPercentage, double threePointsPercentage, double freeThrowsPercentage,
			double efficiencyRating, double winShares, double defensiveWinShares, double usageRate, String name) {
		setId(id2);
		setMinutesPerGame(minutesPerGame);
		setPointsPerGame(pointsPerGame);
		setReboundsPerGame(reboundsPerGame);
		setAssistsPerGame(assistsPerGame);
		setBlocksPerGame(blocksPerGame);
		setStealsPerGame(stealsPerGame);
		setTurnoversPerGame(turnoversPerGame);
		setFoulsPerGame(foulsPerGame);
		setFieldGoalsPercentage(fieldGoalsPercentage);
		setThreePointsPercentage(threePointsPercentage);
		setFreeThrowsPercentage(freeThrowsPercentage);
		setEfficiencyRating(efficiencyRating);
		setWinShares(winShares);
		setDefensiveWinShares(defensiveWinShares);
		setUsageRate(usageRate);
		setName(name);
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSeason() {
		return season;
	}


	public void setSeason(String season) {
		this.season = season;
	}


	public int getId() {
		return id;
	}
	public void setId(int id2) {
		this.id = id2;
	}
	public double getMinutesPerGame() {
		return minutesPerGame;
	}
	public void setMinutesPerGame(double minutesPerGame) {
		this.minutesPerGame = minutesPerGame;
	}
	public double getPointsPerGame() {
		return pointsPerGame;
	}
	public void setPointsPerGame(double pointsPerGame) {
		this.pointsPerGame = pointsPerGame;
	}
	public double getReboundsPerGame() {
		return reboundsPerGame;
	}
	public void setReboundsPerGame(double reboundsPerGame) {
		this.reboundsPerGame = reboundsPerGame;
	}
	public double getAssistsPerGame() {
		return assistsPerGame;
	}
	public void setAssistsPerGame(double assistsPerGame) {
		this.assistsPerGame = assistsPerGame;
	}
	public double getBlocksPerGame() {
		return blocksPerGame;
	}
	public void setBlocksPerGame(double blocksPerGame) {
		this.blocksPerGame = blocksPerGame;
	}
	public double getStealsPerGame() {
		return stealsPerGame;
	}
	public void setStealsPerGame(double stealsPerGame) {
		this.stealsPerGame = stealsPerGame;
	}
	public double getTurnoversPerGame() {
		return turnoversPerGame;
	}
	public void setTurnoversPerGame(double turnoversPerGame) {
		this.turnoversPerGame = turnoversPerGame;
	}
	public double getFoulsPerGame() {
		return foulsPerGame;
	}
	public void setFoulsPerGame(double foulsPerGame) {
		this.foulsPerGame = foulsPerGame;
	}
	public double getFieldGoalsPercentage() {
		return fieldGoalsPercentage;
	}
	public void setFieldGoalsPercentage(double fieldGoalsPercentage) {
		this.fieldGoalsPercentage = fieldGoalsPercentage;
	}
	public double getThreePointsPercentage() {
		return threePointsPercentage;
	}
	public void setThreePointsPercentage(double threePointsPercentage) {
		this.threePointsPercentage = threePointsPercentage;
	}
	public double getFreeThrowsPercentage() {
		return freeThrowsPercentage;
	}
	public void setFreeThrowsPercentage(double freeThrowsPercentage) {
		this.freeThrowsPercentage = freeThrowsPercentage;
	}
	public double getEfficiencyRating() {
		return efficiencyRating;
	}
	public void setEfficiencyRating(double efficiencyRating) {
		this.efficiencyRating = efficiencyRating;
	}
	public double getWinShares() {
		return winShares;
	}
	public void setWinShares(double winShares) {
		this.winShares = winShares;
	}
	public double getDefensiveWinShares() {
		return defensiveWinShares;
	}
	public void setDefensiveWinShares(double defensiveWinShares) {
		this.defensiveWinShares = defensiveWinShares;
	}
	public double getUsageRate() {
		return usageRate;
	}
	public void setUsageRate(double usageRate) {
		this.usageRate = usageRate;
	}
	
	
}
