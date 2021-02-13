package Player;

public class Team {
	public static final int LINEUP_LENGTH = 9;
	public static final int STARTING_ROTATION_LENGTH = 5;
	private PositionPlayer[] lineup;
	private PositionPlayer[] bench;
	private PitchingPlayer[] startingRotation;
	private PitchingPlayer[] bullpen;
	
	public Team() {
		// Initialize the line-up to be 9 hitters long
		lineup = new PositionPlayer[LINEUP_LENGTH];
		// Initialize the starting pitching rotation to be 5 pitchers long
		startingRotation = new PitchingPlayer[STARTING_ROTATION_LENGTH];
	}

}
