package player;

import jplay.Sprite;
import scenes.game.*;

public class Player extends Sprite{
	private Player player;
	
	public Player(int x, int y) {
		super("src/graphics/img/spaceship.png", 10);
		this.x = x;
		this.y = y;
	}
	
	public void move() {
		
		player.moveY(10.0);
		player.moveX(10.0);
	}

}
