package scenes.game;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import scenes.Scene;
import entities.Bullet;
import entities.BulletManager;
import entities.Enemy;
import entities.Obstacle;
import entities.Factory;
import entities.FactoryPhase1;
import scenes.menu.MenuScene;
import text.Text;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import constants.Constants;
import constants.WindowConstants;
import entities.EnemyType;
import player.PlayerSpaceship;
import jplay.GameImage;
import jplay.Sprite;
import jplay.Window;
import player.Player;
import player.Structure;
import player.StructureStrategyJava;
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
	private Player player;
	private BulletManager bullet;
	
	
	protected void initialSetup(){
		keyboard.setBehavior(Keyboard.DOWN_KEY, Keyboard.DETECT_EVERY_PRESS);
		keyboard.setBehavior(Keyboard.UP_KEY, Keyboard.DETECT_EVERY_PRESS);
		keyboard.setBehavior(Keyboard.LEFT_KEY, Keyboard.DETECT_EVERY_PRESS);
		keyboard.setBehavior(Keyboard.RIGHT_KEY, Keyboard.DETECT_EVERY_PRESS);
		keyboard.setBehavior(keyboard.SPACE_KEY, keyboard.DETECT_EVERY_PRESS);
		keyboard.addKey(Keyboard.SPACE_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		keyboard.addKey(KeyEvent.VK_P, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		mouse = game.getMouse();
	}
	
	protected void viewSetup(){
		pauseSetup();
		background = new GameImage("src/graphics/img/space_bg.jpg");
//		playerImage = Player.getInstance();
		((Structure) playerImage).setKeyboard(keyboard);
//		playerImage = new Sprite("src/graphics/img/spaceship.png", 10);
		playerImage.height = 90;
		playerImage.width = 40;
		backgroundSound = new Sound("src/sounds/hbfs.wav");
		if(game.getSoundStatus()) {
			backgroundSound.play();
		}
		bullet = new BulletManager();
	}

	private void pauseSetup() {
		pausedText = new Text(255,240,new Font("Comic Sans MS", Font.BOLD, 60), Color.WHITE, "PAUSADO");
		restartImg = new Sprite("src/graphics/guiPack/white_restart.png");
		restartImg.x = WindowConstants.WIDTH/2 - restartImg.width/2 - restartImg.width - 20;
		restartImg.y = WindowConstants.HEIGHT/2 - restartImg.height/2 + 50;
		exitImg = new Sprite("src/graphics/guiPack/white_home.png");
		exitImg.x = WindowConstants.WIDTH/2 - exitImg.width/2  + restartImg.width + 20;
		exitImg.y = WindowConstants.HEIGHT/2 - exitImg.height/2 + 50;
	}
	
	private void draw() {
		background.draw();
		playerImage.draw();
		for (Enemy enemy: enemies) {
			enemy.draw();
		}
		bullet.draw();
		
		for (Obstacle obst: obstacles) {
			 obst.draw();
		}
	}
	
	public GameScene(Structure structure) {
		super();
		Player.getInstance().setStructure(structure);
		this.playerImage = Player.getInstance().getStructure();
	}

	private void drawPausedButtons () {
		pausedText.draw();
		
		if (game.getSoundStatus()) {
			soundImg = new Sprite("src/graphics/guiPack/white_musicOn.png");
		} else {
			soundImg = new Sprite("src/graphics/guiPack/white_musicOff.png");
		}
		soundImg.x = WindowConstants.WIDTH/2 - soundImg.width/2;
		soundImg.y = WindowConstants.HEIGHT/2 - soundImg.height/2 + 50;
		
		restartImg.draw();
		soundImg.draw();
		exitImg.draw();
	}
	
	private void checkPausedMenuButtonsClick() {
		
		if(mouse.isLeftButtonPressed()) {
			
			if (mouse.isOverObject(restartImg)) {
				currentLevel = new GameScene(((Player)this.playerImage).getStructure());
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
				ArrayList<Sound> sounds = new ArrayList<>();
				sounds.add(backgroundSound);
				game.changeSoundStatus(sounds);
			}
		}
	}

	private void checkKeyboardPress() {
		int floor = 500;
		if (keyboard.keyDown(Keyboard.SPACE_KEY)) {
			if (game.getSoundStatus()) {
				new Sound("src/sounds/shoot_laser.wav").play();
			}
			bullet.addBullet(playerImage.x + playerImage.width/2, playerImage.y + playerImage.height/2, floor);
		} else if ( keyboard.keyDown(KeyEvent.VK_P)) {
			game.pressPause();
		}
		bullet.step(floor);
	}
	
	private void PlayBackgroundSound(Sound backgroundSound) {
		if (!backgroundSound.isExecuting()) {
			backgroundSound.play();
			System.out.println("Play sound");
		}
	}

	private boolean isInside(Sprite sprite) {
		boolean isInside = sprite.x > -20 &&
				           sprite.x < WindowConstants.WIDTH + 20 &&
				           sprite.y > -150 &&
				           sprite.y < WindowConstants.HEIGHT + 20;
		
		return isInside;
	}
	
	public void update(){
		draw();
		checkKeyboardPress();
		
		if (!game.getIsPaused()) {			
			((Structure) playerImage).moveY(2.5);
			((Structure) playerImage).moveX(2.5);
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
			Iterator<Obstacle> itrObs = obstacles.iterator();
			while (itrObs.hasNext()) {
				Obstacle obstacle = itrObs.next();
				
				obstacle.move();
				
				if(!isInside(obstacle)) {
					itrObs.remove();
				}
			}
	
		} else {
			drawPausedButtons();
			checkPausedMenuButtonsClick();
			
		}
	}
}
