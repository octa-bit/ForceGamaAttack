package scenes.game;
import scenes.Scene;

import entities.AbstractEnemy;
import entities.AbstractEnemyFactory;
import entities.EnemyType;
import jplay.GameImage;
import jplay.Sprite;
import player.Player;
import jplay.Keyboard;
import jplay.Sound;

public class GameScene extends Scene {
	private GameImage background;
	private GameImage playerImage;
	private AbstractEnemy enemy;
	private Sound backgroundSound;
	
	protected void initialSetup(){
		keyboard.setBehavior(Keyboard.DOWN_KEY, Keyboard.DETECT_EVERY_PRESS);
		keyboard.setBehavior(Keyboard.UP_KEY, Keyboard.DETECT_EVERY_PRESS);
		keyboard.setBehavior(Keyboard.LEFT_KEY, Keyboard.DETECT_EVERY_PRESS);
		keyboard.setBehavior(Keyboard.RIGHT_KEY, Keyboard.DETECT_EVERY_PRESS);
		keyboard.addKey(Keyboard.SPACE_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
	}
	
	protected void viewSetup(){
		background = new GameImage("src/graphics/img/space_bg.jpg");
		playerImage = new Player(100, 100);
//		playerImage = new Sprite("src/graphics/img/spaceship.png", 10);
		playerImage.x = 360.0;
		playerImage.y = 550.0;
		playerImage.height = 90;
		playerImage.width = 40;
		enemy = AbstractEnemyFactory.getFactory(EnemyType.ISSUE);
		enemy.setPosition(100.0, 100.0);
		enemy.setSize(300, 400);
		backgroundSound = new Sound("src/sounds/blackhole_sound.wav");
		backgroundSound.play();
	}
	
	private void draw() {
		background.draw();
		playerImage.draw();
		enemy.draw();
	}
	
	private void CheckKeyboardPress() {
		if (keyboard.keyDown(Keyboard.SPACE_KEY)) {
			new Sound("src/sounds/shoot_laser.wav").play();
		}
	}
	
	private void PlayBackgroundSound(Sound backgroundSound) {
		if (!backgroundSound.isExecuting()) {
			backgroundSound.play();
			System.out.println("Play sound");
		}
	}

	public void update(){
		draw();
		CheckKeyboardPress();
		PlayBackgroundSound(backgroundSound);
		((Sprite) playerImage).moveY(2.5);
		((Sprite) playerImage).moveX(2.5);
		enemy.move();
	}
}
