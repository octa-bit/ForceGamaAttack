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
	protected String bulletSprite;
	protected int gunShootingSpeed;
	protected int gunDamage;
	
	public Structure(int x, int y, String sprite, int health) {	
		super(sprite, 10);
		this.x = x;
		this.y = y;
		this.speed = 10.0;
		this.health = health;
		this.maxHealth = health;
	}
	
	public String getBulletSprite() {
		return this.bulletSprite;
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

	public int getGunShootingSpeed() {
		return this.gunShootingSpeed;
	}

	public int getGunDamage() {
		return this.gunDamage;
	}

}
