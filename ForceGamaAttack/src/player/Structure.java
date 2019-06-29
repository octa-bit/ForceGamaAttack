package player;

import jplay.Keyboard;
import jplay.Sprite;

public abstract class Structure extends Sprite{
	private int health;
	private int maxHealth;
	double speed;
	int armor;
	int size;
	int powerUp;
	protected int height;
	protected int width;
	private Keyboard keyboard = new Keyboard();

	public Structure(int x, int y, String sprite, int health) {	
		super(sprite, 10);
		this.x = x;
		this.y = y;
		this.speed = 10.0;
		this.health = health;
		this.maxHealth = health;
	}
	
	protected Keyboard getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(Keyboard keyboard) {
		this.keyboard = keyboard;
	}

	public int getHealth() {
		return this.health;
	}
	
	public int getMaxHealth() {
		return this.maxHealth;
	}

	public void resetHealth() {
		this.health = this.maxHealth;
	}
	
	public void takeDamage(int damage) {
		this.health -= damage;
	}
	
	public abstract void moveX(double x);
	public abstract void moveY(double y);

	public int getHeight() {
		return this.height;
	}
	public int getWidth() {
		return this.width;
	}
}
