package player;

import jplay.Sprite;	

public abstract class Player extends Sprite{
	private Player player;
	double speed;
	String sprite = "src/graphics/img/spaceship.png";
	
	public Player(int x, int y, String sprite) {	
		super(sprite, 10);
		this.x = x;
		this.y = y;
		this.speed = 10.0;
	}
	
	public void move() {
		
		player.moveY(this.speed);
		player.moveX(this.speed);
	}
}
