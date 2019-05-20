package player;

public class Player {
	private PlayerSpaceship spaceship;

	public PlayerSpaceship getSpaceship() {
		
		if (spaceship == null) {
			spaceship = new PlayerSpaceship(this, this.initialPositionY, this.initialPositionY, true);
		}
		return spaceship;
	}

	public void setSpaceship(PlayerSpaceship spaceship) {
		this.spaceship = spaceship;
	}
}
