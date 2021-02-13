package Game;

public enum Results {
	STRIKEOUT(0), GROUND_OUT(1), FLY_OUT(2), LINE_OUT(3), DOUBLE_PLAY(4),
	SINGLE(5), DOUBLE(6), TRIPLE(7), HOME_RUN(8), WALK(9), HIT_BY_PITCH(10);
	private int value;

	Results(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
}
