package player;

import java.awt.event.KeyEvent;

import jplay.Keyboard;
import jplay.Sprite;
import constants.WindowConstants;

public abstract class Structure extends Sprite{
	private int health;
	private int maxHealth;
	protected double speed;
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
	
	public void moveX(double x) {
		if(this.getKeyboard().keyDown(KeyEvent.VK_RIGHT) &&
		   this.x + this.width < WindowConstants.WIDTH) {
			this.x += x * speed;
		}
		else if(this.getKeyboard().keyDown(KeyEvent.VK_LEFT) &&
				this.x > 0) {
			this.x -= x * speed;
		}
	}
	
	public void moveY(double y) {
		if(this.getKeyboard().keyDown(KeyEvent.VK_DOWN) &&
		   this.y + this.height < WindowConstants.HEIGHT) {
			this.y += y * speed;
		}
		else if(this.getKeyboard().keyDown(KeyEvent.VK_UP) &&
				this.y > 0) {
			this.y -= y * speed;
		}
	}

	public int getHeight() {
		return this.height;
	}
	public int getWidth() {
		return this.width;
	}
}
