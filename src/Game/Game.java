package Game;

import Player.PitchingPlayer;
import Player.Team;

public class Game {
	public static final int INNINGS_TO_PLAY = 9;
	private int homeScore = 0;
	private int awayScore = 0;
	private Team homeTeam;
	private Team awayTeam;
	private int awayLineupPosition = 0;
	private int homeLineupPosition = 0;
	private PitchingPlayer currentHomePitcher;
	private PitchingPlayer currentAwayPitcher;
	
	public Game(Team homeTeam, Team awayTeam, int homeStartingPitcher, int awayStartingPitcher) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		currentHomePitcher = homeTeam.getStartingRotation()[homeStartingPitcher];
		currentAwayPitcher = awayTeam.getStartingRotation()[awayStartingPitcher];
	}
	
	// plays a 9 inning game and tracks the score each team. Team with the highest score after 9 innings wins
	// if there is a tie after 9 innings, then the team plays extra innings until one team has a higher score after an inning
	public void playGame() {
		// play through all the innings in the game
		// if the score is tied after the standard innings are played, play extra innings until one team has a higher score
		int inning = 1;
		while(inning <= 9 || homeScore == awayScore) {
			// complete the away side of the inning
			Inning awayInning = new Inning(awayTeam.getLineup(), currentHomePitcher,
					homeTeam.getBullpen(), awayLineupPosition);
			// store the runs and the current positions of pitchers and lineups
			awayScore += awayInning.getRuns();
			awayLineupPosition = awayInning.getCurrentLineupPosition();
			currentHomePitcher = awayInning.getPitcher();
			
			// complete the home side of the inning
			Inning homeInning = new Inning(homeTeam.getLineup(), currentAwayPitcher,
					awayTeam.getBullpen(), homeLineupPosition);
			// store the runs and the current positions of pitchers and lineups
			homeScore += homeInning.getRuns();
			homeLineupPosition = homeInning.getCurrentLineupPosition();
			currentAwayPitcher = homeInning.getPitcher();
			
			inning++;
		}
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
