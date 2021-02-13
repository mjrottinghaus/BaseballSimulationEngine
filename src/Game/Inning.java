package Game;

import Player.PitchingPlayer;
import Player.PositionPlayer;

public class Inning {
	public static final int OUTS_PER_INNING = 3;
	private int runs = 0;
	private int outs = 0;
	private PositionPlayer[] lineup;
	private PitchingPlayer pitcher;
	private PitchingPlayer[] bullpenPitchers;
	private int currentLineupPosition;
	
	public Inning(PositionPlayer[] lineup, PitchingPlayer pitcher, PitchingPlayer[] bullpenPitchers, int lineupPosition) {
		super();
		this.lineup = lineup;
		this.pitcher = pitcher;
		this.bullpenPitchers = bullpenPitchers;
		currentLineupPosition = lineupPosition;
	}
	
	public void completeInning() {
		
	}

	public int getRuns() {
		return runs;
	}

	public PitchingPlayer getPitcher() {
		return pitcher;
	}

	public int getCurrentLineupPosition() {
		return currentLineupPosition;
	}

}
