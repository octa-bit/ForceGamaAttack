package player;

import jplay.Sprite;	

public class Player extends Sprite{
	private Player player;
	
	private static final Player INSTANCE = new Player(360, 550);
	
	private Player(int x, int y) {
		super("src/graphics/img/spaceship.png", 10);
		this.x = x;
		this.y = y;
	}
	
	public static Player getInstance() {
		return INSTANCE;
	}
	
	public void move() {
		
		player.moveY(10.0);
		player.moveX(10.0);
	}

}
