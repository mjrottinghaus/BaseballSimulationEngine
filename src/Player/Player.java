package Player;

public abstract class Player {
	public enum Hand {LEFT, RIGHT};
	private Hand batting;
	private Hand throwing;
	private String lastName;
	private String firstName;
	private Position position;
	
	public Player(Hand batting, Hand throwing, String lastName, String firstName, Position position) {
		this.batting = batting;
		this.throwing = throwing;
		this.lastName = lastName;
		this.firstName = firstName;
		this.position = position;
	}
	

}
