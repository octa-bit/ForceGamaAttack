package player;

import jplay.Sprite;

public class Player extends Sprite{
	private Player player;
	
	public Player(int x, int y) {
		super("src/graphics/img/spaceship.png", 10);
		this.x = x;
		this.y = y;
	}
	
	public void move() {
	}

}
