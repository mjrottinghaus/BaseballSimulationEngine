package Player;

public enum Position {
	SP ("Starting Pitcher"), RP("Relief Pitcher"), C("Catcher"), B1("First Base"), B2("Second Base"), B3("Third Base"),
	SS("Shortstop"), LF("Left Field"), CF("Center Field"), RF("Right Field");
	private String value;
	
	Position(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
