package player;

import player.PlayerSpaceship;

public class Player {
	private PlayerSpaceship spaceship;
	public double iniPositionX = 0;
	public double iniPositionY = 0;
	
	public PlayerSpaceship getSpaceship() {
		
		if (spaceship == null){
		//	spaceship = new PlayerSpaceship(this, this.iniPositionY, this.iniPositionY, true);
		}
		
		return spaceship;
	}

}
