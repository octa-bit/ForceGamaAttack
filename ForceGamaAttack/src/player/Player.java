package player;
import jplay.Keyboard;

import jplay.Sprite;	

public abstract class Player extends Sprite{
	private Player player;
	double speed;
	String sprite = "src/graphics/img/spaceship.png";
	Keyboard keyboard;
	
	public Player(int x, int y, String sprite, Keyboard keyboard) {	
		super(sprite, 10);
		this.x = x;
		this.y = y;
		this.speed = 10.0;
		this.keyboard = keyboard;
	}
	
}
