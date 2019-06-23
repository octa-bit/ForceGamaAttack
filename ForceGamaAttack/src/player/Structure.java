package player;

import jplay.Keyboard;
import jplay.Sprite;

public abstract class Structure extends Sprite{
	int health;
	double speed;
	int armor;
	int size;
	int powerUp;
	private Keyboard keyboard = new Keyboard();

	public Structure(int x, int y, String sprite) {	
		super(sprite, 10);
		this.x = x;
		this.y = y;
		this.speed = 10.0;
	}
	
	protected Keyboard getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(Keyboard keyboard) {
		this.keyboard = keyboard;
	}
	
	public abstract void moveX(double x);
	public abstract void moveY(double y);
	
	
}
