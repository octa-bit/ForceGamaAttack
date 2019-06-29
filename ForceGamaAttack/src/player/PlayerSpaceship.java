package player;

import entities.Bullet;
import jplay.Keyboard;

public class PlayerSpaceship{
	private static final int defaultMovimentVel = 4;
	private Player player;
	
	private int upKey = Keyboard.UP_KEY;
	private int downKey = Keyboard.DOWN_KEY;
	private int leftKey = Keyboard.LEFT_KEY;
	private int rightKey = Keyboard.RIGHT_KEY;
	private int shootKey = 0;

	private double x;
	private double y;	
	private boolean canShoot = true;
	
	public double movimentVel = defaultMovimentVel;



	public PlayerSpaceship(Player player, double x, double y, boolean adjust) {
	
		this.x = x;
		this.y = y;
		this.player = player;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public void setKeySet(int upKey, int downKey, int leftKey,  int rightKey, int shootKey) {
		this.upKey = upKey;
		this.downKey = downKey;
		this.rightKey = rightKey;
		this.leftKey = leftKey;
		this.shootKey = shootKey;
	}
}