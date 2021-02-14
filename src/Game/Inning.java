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
	// bases represent if there is a player on a base during an inning
	private PositionPlayer[] bases = {null, null, null};
	
	public Inning(PositionPlayer[] lineup, PitchingPlayer pitcher, PitchingPlayer[] bullpenPitchers, int lineupPosition) {
		super();
		this.lineup = lineup;
		this.pitcher = pitcher;
		this.bullpenPitchers = bullpenPitchers;
		currentLineupPosition = lineupPosition;
	}
	
	public void completeInning() {
		// the hitting team continues to try and score while there are fewer than the max outs per inning
		while(outs < OUTS_PER_INNING) {
			AtBat currentAB = new AtBat(lineup[currentLineupPosition], pitcher);
			currentAB.completeAtBat();
			// check to see if the batter made an out
			if(currentAB.getResult().getValue() < 5) outs++;
			// if the batter made it on base, check to see if runners need to move and runs should be scored
			if(currentAB.getResult().getValue() >= 5) {
				// if the batter advances to the first base, move the runners accordingly and likewise for the other bases
				if(currentAB.getResult() == Results.SINGLE || currentAB.getResult() == Results.WALK ||
						currentAB.getResult() == Results.HIT_BY_PITCH) {
					moveBases(lineup[currentLineupPosition], 1);
				}
				if(currentAB.getResult() == Results.DOUBLE) {
					moveBases(lineup[currentLineupPosition], 2);
				}
				if(currentAB.getResult() == Results.TRIPLE) {
					moveBases(lineup[currentLineupPosition], 3);
				}
				if(currentAB.getResult() == Results.HOME_RUN) {
					moveBases(lineup[currentLineupPosition], 4);
				}
			}
			
			//TODO check to see if the pitcher needs to be changed
			
			currentLineupPosition++;
		}
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
	
	// checks the bases on the field and moves the runners based on where the main runner is going
	public void moveBases(PositionPlayer runner, int base) {
		// move each runner starting with the last one
		for(int i = 2; i >= 0; i--) {
			// check if there is a runner to move at the base
			if(bases[i] != null) {
				// determine which base the runner should be at
				int newBase = i + base;
				// check if the runner has scored
				if(newBase > 2) {
					// remove the runner from the bases and increase the score
					bases[i] = null;
					runs++;
				}
				// move the runner to their new base
				bases[newBase] = bases[i];
				bases[i] = null;
			}
			
		}
		// check if the batter scores or is otherwise placed at their base
		if(base > 2) runs++;
		else bases[base] = runner;
	}

}
