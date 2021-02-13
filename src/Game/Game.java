package Game;

import Player.Team;

public class Game {
	private int homeScore = 0;
	private int awayScore = 0;
	private Team homeTeam;
	private Team awayTeam;
	
	public Game(Team homeTeam, Team awayTeam) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
	}
	
	// plays a 9 inning game and tracks the score each team. Team with the highest score after 9 innings wins
	// if there is a tie after 9 innings, then the team plays extra innings until one team has a higher score after an inning
	public void playGame() {
		
	}

	public int getHomeScore() {
		return homeScore;
	}

	public int getAwayScore() {
		return awayScore;
	}

	public void printBoxScore() {
		
	}
	
	public Team getWinningTeam() {
		// whichever team has the higher score gets returned
		if(homeScore > awayScore) return homeTeam;
		return awayTeam;
	}
	

}
