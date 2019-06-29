package scenes.game;
import java.util.List;
import java.util.ArrayList;
import scenes.Scene;

import entities.Enemy;
import entities.Factory;
import entities.FactoryPhase1;
import scenes.menu.MenuScene;
import text.ScoreText;
import text.Text;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import constants.WindowConstants;
import entities.EnemyType;
import jplay.GameImage;
import jplay.Sprite;
import player.Player;
import player.StructureStrategyJava;
import jplay.Keyboard;
import jplay.Sound;
import jplay.Collision;
import jplay.Mouse;

public class GameScene extends Scene {
	private Text score;
	private Text scoreHigh;
	private GameImage background;
	private GameImage playerImage;
	private Sound backgroundSound;
	private Collision collision;
	private List<Enemy> enemies = new ArrayList<Enemy>();
	private Factory fac = new FactoryPhase1();
	private Text pausedText;
	private Sprite restartImg;
	private Sprite soundImg;
	private Sprite exitImg;
	private Mouse mouse;
	private Scene currentLevel;
	private Scene menuScene;
	private ScoreText scoris;
	private int scori=0;
	
	
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
		pauseSetup();
		score = new Text(550,20,new Font("Comic Sans MS", Font.BOLD, 20), Color.WHITE, "HIGH SCORE: 000000");
		scoris = new ScoreText(550,50,new Font("Comic Sans MS", Font.BOLD, 20), Color.WHITE);
//		scoreHigh = new Text(550,50,new Font("Comic Sans MS", Font.BOLD, 20), Color.WHITE, scori );	
		background = new GameImage("src/graphics/img/space_bg.jpg");
		((Player) playerImage).setKeyboard(keyboard);
//		playerImage = new Sprite("src/graphics/img/spaceship.png", 10);
	//	score.x = 600.0;
	//	score.y = 10.0;
		playerImage.x = 360.0;
		playerImage.y = 550.0;
		playerImage.height = 90;
		playerImage.width = 40;
		backgroundSound = new Sound("src/sounds/hbfs.wav");
		if(game.getSoundStatus()) {
			backgroundSound.play();
		}
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
		score.draw();
		scoris.draw();
		playerImage.draw();
		for (Enemy enemy: enemies) {
			enemy.draw();
		}
	}
	
	public GameScene(GameImage playerImage) {
		super();
		this.playerImage = playerImage;
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
				currentLevel = new GameScene(this.playerImage);
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
		if (keyboard.keyDown(Keyboard.SPACE_KEY)) {
			if (game.getSoundStatus()) {
				new Sound("src/sounds/shoot_laser.wav").play();
				scori=scori+100;
				scoris.setScore(scori);
			}
		} else if ( keyboard.keyDown(KeyEvent.VK_P)) {
			game.pressPause();
		}
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
			for (Enemy enemy: enemies) {
				enemy.move();
				if(Collision.collided(playerImage,enemy)) {
					// do something after colliding
				}
			}
		} else {
			drawPausedButtons();
			checkPausedMenuButtonsClick();
		}
	}
}
