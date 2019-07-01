package player;

import jplay.Sprite;

public class PowerUp extends Sprite{
	public enum PowerUpType {
		HAPPINESS , TEP, IHCS2, MAUMI, ROCHA;
	}
	public enum PowerUpState {
		ACTIVATED, DEACTIVATED;
	}
	
	private static String sprite = "src/graphics/img/top.png";
	
	private PowerUpState state;
	private PowerUpType type;
	private String name;
	private int duration;
	
	public PowerUp(String sprite, float x, float y,
				   PowerUpType type, String name, int duration) {
		super(sprite);
		this.x = x;
		this.y = y;
		this.type = type;
		this.name = name;
		this.duration = duration;
		this.state = PowerUpState.ACTIVATED;
	}
	
	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void move() {
		this.y += 0.6;
	}
	
	public PowerUpType getType() {
		return this.type;
	}
	
	public int getDuration() {
		return this.duration;
	}
	
	public boolean isActivated() {
		if(this.state == PowerUpState.ACTIVATED) {
			return true;
		}
		else {
			return false;
		}
	}
}
