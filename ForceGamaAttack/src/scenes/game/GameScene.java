package scenes.game;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import scenes.Scene;

import entities.Enemy;
import entities.Obstacle;
import entities.Factory;
import entities.FactoryPhase1;
import scenes.menu.MenuScene;
import text.Text;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import constants.WindowConstants;
import entities.EnemyType;
import jplay.GameImage;
import jplay.Sprite;
import player.Player;
import jplay.Keyboard;
import jplay.Sound;
import jplay.Collision;
import jplay.Mouse;

public class GameScene extends Scene {
	private GameImage background;
	private GameImage playerImage;
	private Sound backgroundSound;
	private List<Enemy> enemies = new ArrayList<Enemy>();
	private List<Obstacle> obstacles = new ArrayList<Obstacle>();
	private Factory fac = new FactoryPhase1();
	private Text pausedText;
	private Sprite restartImg;
	private Sprite soundImg;
	private Sprite exitImg;
	private Mouse mouse;
	private Scene currentLevel;
	private Scene menuScene;
	
	
	protected void initialSetup(){
		keyboard.setBehavior(Keyboard.DOWN_KEY, Keyboard.DETECT_EVERY_PRESS);
		keyboard.setBehavior(Keyboard.UP_KEY, Keyboard.DETECT_EVERY_PRESS);
		keyboard.setBehavior(Keyboard.LEFT_KEY, Keyboard.DETECT_EVERY_PRESS);
		keyboard.setBehavior(Keyboard.RIGHT_KEY, Keyboard.DETECT_EVERY_PRESS);
		keyboard.addKey(Keyboard.SPACE_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		keyboard.addKey(KeyEvent.VK_P, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		mouse = game.getMouse();
	}
	
	protected void viewSetup(){
		background = new GameImage("src/graphics/img/space_bg.jpg");
		playerImage = Player.getInstance();
//		playerImage = new Sprite("src/graphics/img/spaceship.png", 10);
		playerImage.height = 90;
		playerImage.width = 40;
		
		backgroundSound = new Sound("src/sounds/hbfs.wav");
//		backgroundSound.play();
	}
	
	private void draw() {
		background.draw();
		playerImage.draw();
		for (Enemy enemy: enemies) {
			enemy.draw();
		}
		for (Obstacle obst: obstacles) {
			 obst.draw();
		}
	}
	
	private void drawPausedButtons () {
		pausedText = new Text(255,240,new Font("Comic Sans MS", Font.BOLD, 60), Color.WHITE, "PAUSADO");
		pausedText.draw();
		
		restartImg = new Sprite("src/graphics/guiPack/white_restart.png");
		restartImg.x = WindowConstants.WIDTH/2 - restartImg.width/2 - restartImg.width - 20;
		restartImg.y = WindowConstants.HEIGHT/2 - restartImg.height/2 + 50;
		
		if (game.getSoundStatus()) {
			soundImg = new Sprite("src/graphics/guiPack/white_musicOff.png");
		} else {
			soundImg = new Sprite("src/graphics/guiPack/white_musicOn.png");
		}
		soundImg.x = WindowConstants.WIDTH/2 - soundImg.width/2;
		soundImg.y = WindowConstants.HEIGHT/2 - soundImg.height/2 + 50;
		
		exitImg = new Sprite("src/graphics/guiPack/white_home.png");
		exitImg.x = WindowConstants.WIDTH/2 - exitImg.width/2  + restartImg.width + 20;
		exitImg.y = WindowConstants.HEIGHT/2 - exitImg.height/2 + 50;
		
		restartImg.draw();
		soundImg.draw();
		exitImg.draw();
	}
	
	private void checkPausedMenuButtonsClick() {
		
		if(mouse.isLeftButtonPressed()) {
			
			if (mouse.isOverObject(restartImg)) {
				currentLevel = new GameScene();
				game.pressPause();
				game.transitTo(currentLevel);
				backgroundSound.stop();
			} else if (mouse.isOverObject(exitImg)) {
				menuScene = new MenuScene();
				game.pressPause();
				game.keyboard.removeKey(Keyboard.ENTER_KEY);
				game.transitTo(menuScene);
				backgroundSound.stop();
			} else if (mouse.isOverObject(soundImg)) {
				game.changeSoundStatus();
				// Mute or unmute the sound of the game
			}
		}
	}
	
	private void checkKeyboardPress() {
		if (keyboard.keyDown(Keyboard.SPACE_KEY)) {
			new Sound("src/sounds/shoot_laser.wav").play();
		} else if ( keyboard.keyDown(KeyEvent.VK_P)) {
			game.pressPause();
		}
	}

	private boolean isInside(Sprite sprite) {
		boolean isInside = sprite.x > -20 &&
				           sprite.x < WindowConstants.WIDTH + 20 &&
				           sprite.y > -20 &&
				           sprite.y < WindowConstants.HEIGHT + 20;
		
		return isInside;
	}
	
	public void update(){
		draw();
		checkKeyboardPress();
		
		if (!game.getIsPaused()) {			
			((Sprite) playerImage).moveY(2.5);
			((Sprite) playerImage).moveX(2.5);
			if (fac.isSpawnTime()) {
				enemies.addAll(fac.factoryMethod());
			}
			
			// Enemy things
			Iterator<Enemy> itrEnemy = enemies.iterator();
			while (itrEnemy.hasNext()) {
				Enemy enemy = itrEnemy.next();
				
				enemy.move();	
				
				if (!isInside(enemy)) {
					itrEnemy.remove();
					System.out.println("Remove");
					continue;
				}
				
				if(Collision.collided(playerImage,enemy)) {
					// System.out.println("collided");
				}				
				if(enemy.isShooting()) {
					obstacles.add(enemy.shoot());
				}
			}
			
			// Obstacle things
			for (Obstacle obstacle: obstacles) {
				obstacle.move();
			}
		} else {
			drawPausedButtons();
			checkPausedMenuButtonsClick();
		}
	}
}
