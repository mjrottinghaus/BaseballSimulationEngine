package Game;

import Player.*;

public class AtBat {
	private PositionPlayer hitter;
	private PitchingPlayer pitcher;
	private int strikes = 0;
	private int balls = 0;
	
	public AtBat(PositionPlayer hitter, PitchingPlayer pitcher) {
		this.hitter = hitter;
		this.pitcher = pitcher;
	}

}
