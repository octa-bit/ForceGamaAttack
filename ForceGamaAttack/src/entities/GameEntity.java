package entities;

import jplay.Sprite;

public class GameEntity extends Sprite{
	
	public String name;
	public Double velx = 0.0;
	public Double vely = 0.0;
	public boolean isCollidable = true;
	public World gameWorld = null;
	
	public GameEntity(String fileName) {
		super(fileName);
		name = fileName;
	}
	
	public void update() {
		
	}
	
	public void reborn(){
		this.x = 0;
		this.y = 0;
		this.velx = 0.0;
		this.vely = 0.0;
		this.name = "empty entity";
	}
}
