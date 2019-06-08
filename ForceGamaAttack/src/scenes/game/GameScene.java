package scenes.game;
import java.util.List;
import java.util.ArrayList;
import scenes.Scene;
import entities.Enemy;
import entities.Factory;
import entities.FactoryPhase1;
import jplay.GameImage;
import jplay.Sprite;
import player.Player;
import jplay.Keyboard;
import jplay.Collision;

public class GameScene extends Scene {
	private GameImage background;
	private GameImage playerImage;
	private Collision collision;
	private List<Enemy> enemies = new ArrayList<Enemy>();
	private Factory fac = new FactoryPhase1();
	
	protected void initialSetup(){
		keyboard.setBehavior(Keyboard.DOWN_KEY, Keyboard.DETECT_EVERY_PRESS);
		keyboard.setBehavior(Keyboard.UP_KEY, Keyboard.DETECT_EVERY_PRESS);
		keyboard.setBehavior(Keyboard.LEFT_KEY, Keyboard.DETECT_EVERY_PRESS);
		keyboard.setBehavior(Keyboard.RIGHT_KEY, Keyboard.DETECT_EVERY_PRESS);
	}
	
	protected void viewSetup(){
		background = new GameImage("src/graphics/img/space_bg.jpg");
		playerImage = new Player(100, 100);
//		playerImage = new Sprite("src/graphics/img/spaceship.png", 10);
		playerImage.x = 360.0;
		playerImage.y = 550.0;
		playerImage.height = 90;
		playerImage.width = 40;
	}
	
	private void draw() {
		background.draw();
		playerImage.draw();
		for (Enemy enemy: enemies) {
			enemy.draw();
		}
	}

	public void update(){
		((Sprite) playerImage).moveY(2.5);
		((Sprite) playerImage).moveX(2.5);
		if (fac.isSpawnTime()) {
			enemies.addAll(fac.factoryMethod());
		}
		for (Enemy enemy: enemies) {
			enemy.move();
			if(Collision.collided(playerImage,enemy)) {
				System.out.println("oi");
			}
		}
		
		draw();
	}
}
