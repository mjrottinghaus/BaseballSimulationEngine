package Game;

import Player.*;

public class AtBat {
	private PositionPlayer hitter;
	private PitchingPlayer pitcher;
	private int strikes = 0;
	private int balls = 0;
	private Results result;
	
	public AtBat(PositionPlayer hitter, PitchingPlayer pitcher) {
		this.hitter = hitter;
		this.pitcher = pitcher;
	}
	
	public void completeAtBat() {
		
	}

	public Results getResult() {
		return result;
	}
	
}
