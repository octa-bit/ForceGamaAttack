package player;

import entities.Bullet;
import entities.GameEntity;
import jplay.Keyboard;

public class PlayerSpaceship extends GameEntity{
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
		super("teste");
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
	
	public void fireBullet(){
		
		if (canShoot){
			canShoot = false;
			System.out.println("Fire Bullet!");
			Bullet bullet = new Bullet();
			bullet.fireBy(this, -10);
		}
		
	}
	
	public void checkInput(){
		
		System.out.println("entrei check");
		//Player movement
		moveX(leftKey, rightKey, this.movimentVel);
		moveY(upKey, downKey, this.movimentVel);
		
		//shootKey
		if(gameWorld != null){
			if (gameWorld.keyboard != null){
				if(gameWorld.keyboard.keyDown(shootKey)){
					this.fireBullet();
					System.out.println("testeee");
				}
			}
		}
	}
	
	@Override
	public void moveX(int leftKey, int rightKey, double vel){
		if(gameWorld != null){
			
			if (gameWorld.keyboard != null){
				
				if(gameWorld.keyboard.keyDown(leftKey)){
					this.x -= vel;
				}
				
				if(gameWorld.keyboard.keyDown(rightKey)){
					this.x += vel;
				}
			}
		}
	}
	
	@Override
	public void moveY(int upKey, int downKey, double vel){
		if(gameWorld != null){
			
			if (gameWorld.keyboard != null){
				
				if(gameWorld.keyboard.keyDown(upKey)){
					this.y -= vel;
				}
				
				if(gameWorld.keyboard.keyDown(downKey)){
					this.y += vel;
				}
			}
		}
	}
	
	@Override
	public void update() {
		checkInput();
	}
}