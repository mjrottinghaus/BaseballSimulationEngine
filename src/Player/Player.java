package Player;

public abstract class Player {
	private String lastName;
	private String firstName;
	private Position position;
	
	
	public Player(String lastName, String firstName, Position position) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
	}

}
