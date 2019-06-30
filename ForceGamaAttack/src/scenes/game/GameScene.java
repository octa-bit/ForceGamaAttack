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
import score.Score;
import text.ScoreText;
import scenes.spaceShipMenu.SpaceShipMenuScene;
import text.Text;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import constants.WindowConstants;
import jplay.GameImage;
import jplay.Sprite;
import player.Gun;
import player.Player;
import player.Structure;
import jplay.Keyboard;
import jplay.Sound;
import jplay.Collision;
import jplay.Mouse;
import jplay.Parallax;

public class GameScene extends Scene {
	private Text highScore;
	private ScoreText scoreHigh;
	private GameImage playerImage;
	private GameImage backgroundGameOver;
	private Sound backgroundSound;
	private List<Enemy> enemies = new ArrayList<Enemy>();
	private List<Obstacle> obstacles = new ArrayList<Obstacle>();
	private Factory fac = new FactoryPhase1();
	private Text pausedText;
	private Sprite restartImg;
	private Sprite soundImg;
	private Text gameOverText;
	private Sprite gameOverExitImg;
	private Sprite gameOverRestartImg;
	private Sprite exitImg;
	private Mouse mouse;
	private Scene currentLevel;
	private Scene menuScene;
  
	private BulletManager bullet;
	private Sprite lifeBarBackground;
	private Sprite lifeBar;
	private Score gameScore;
	private Sound gameOverSound;
	private Parallax parallax;
	private Text pauseText;
	
	protected void initialSetup(){
		keyboard.setBehavior(Keyboard.DOWN_KEY, Keyboard.DETECT_EVERY_PRESS);
		keyboard.setBehavior(Keyboard.UP_KEY, Keyboard.DETECT_EVERY_PRESS);
		keyboard.setBehavior(Keyboard.LEFT_KEY, Keyboard.DETECT_EVERY_PRESS);
		keyboard.setBehavior(Keyboard.RIGHT_KEY, Keyboard.DETECT_EVERY_PRESS);
		keyboard.setBehavior(keyboard.SPACE_KEY, keyboard.DETECT_EVERY_PRESS);
		keyboard.addKey(KeyEvent.VK_P, Keyboard.DETECT_INITIAL_PRESS_ONLY);
		mouse = game.getMouse();
	}
	
	protected void viewSetup(){
		parallax = new Parallax();
		parallax.add("src/graphics/img/back_transp.png");
		parallax.getLayer(0).setVelY(2.0);
		pauseSetup();
		highScore = new Text(550,20,new Font("Comic Sans MS", Font.BOLD, 20), Color.WHITE, "HIGH SCORE: 000000");
		scoreHigh = new ScoreText(550,50,new Font("Comic Sans MS", Font.BOLD, 20), Color.WHITE);	
		
		((Structure) playerImage).setKeyboard(keyboard);
		gameOverSetup();
		((Structure) playerImage).setKeyboard(keyboard);
		lifeBar = new Sprite("src/graphics/guiPack/lifebar2.png");
		lifeBarBackground = new Sprite("src/graphics/guiPack/lifebar_1.png");
		lifeBarBackground.x = 39;
		lifeBarBackground.y = 40;
		lifeBar.x = 40;
		lifeBar.y = 40;
		playerImage.height = ((Structure) playerImage).getHeight();
		playerImage.width = ((Structure) playerImage).getWidth();
		backgroundSound = new Sound("src/sounds/hbsf.wav");
		if(game.getSoundStatus()) {
			backgroundSound.play();
		}
		bullet = new BulletManager();
		gameScore = new Score();
		pauseText = new Text(630,580,new Font("Comic Sans MS", Font.BOLD, 20), Color.WHITE, "P (PAUSE)");
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
	
	private void gameOverSetup() {
		backgroundGameOver = new GameImage("src/graphics/img/gameover.png");
		gameOverText = new Text(230,240,new Font("Comic Sans MS", Font.BOLD, 55), Color.WHITE, "GAME OVER");
		gameOverRestartImg = new Sprite("src/graphics/guiPack/white_restart.png");
		gameOverRestartImg.x = WindowConstants.WIDTH/2 - restartImg.width/2 - restartImg.width - 20;
		gameOverRestartImg.y = WindowConstants.HEIGHT/2 - restartImg.height/2 + 50;
		gameOverExitImg = new Sprite("src/graphics/guiPack/white_home.png");
		gameOverExitImg.x = WindowConstants.WIDTH/2 - exitImg.width/2  + restartImg.width + 20;
		gameOverExitImg.y = WindowConstants.HEIGHT/2 - exitImg.height/2 + 50;
		gameOverSound = new Sound("src/sounds/gameover.wav");
	}
	
	private void draw() {
		
		updateParallax();
		pauseText.draw();
		playerImage.draw();
		for (Enemy enemy: enemies) {
			enemy.draw();
		}
		
		bullet.draw();
		
		for (Obstacle obst: obstacles) {
			 obst.draw();
		}
		lifeBarBackground.draw();
		renderLifeBar();
		highScore.draw();
		scoreHigh.draw();
	}
	
	public void updateParallax(){
  		parallax.drawLayers();
  		parallax.repeatLayers(800, 600, false);

		if (!game.getIsPaused() && !game.getIsGameOver()) {
  			parallax.moveLayersStandardY(false);
		} 
  	}
	
	public GameScene(Structure structure, Gun gun) {
		super();
		Player.getInstance().setStructure(structure);
		Player.getInstance().setGun(gun);
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
	
	private void drawGameOverButtons () {
		game.keyboard.removeKey(KeyEvent.VK_P);
		backgroundGameOver.draw();
		gameOverText.draw();
		gameOverRestartImg.draw();
		gameOverExitImg.draw();
	}
	
	private void checkPausedMenuButtonsClick() {
		
		if(mouse.isLeftButtonPressed()) {
			
			if (mouse.isOverObject(restartImg)) {
				currentLevel = new SpaceShipMenuScene();
				// currentLevel = new GameScene(Player.getInstance().getStructure());
				game.pressPause();
				Player.getInstance().width = 50;
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
	
	private void checkGameOverMenuButtonsClick() {
		
		if(mouse.isLeftButtonPressed()) {
			
			if (mouse.isOverObject(gameOverRestartImg)) {
				currentLevel = new GameScene(Player.getInstance().getStructure(), Player.getInstance().getGun());
				game.setNewGame();
				((Structure) playerImage).resetHealth();
				game.transitTo(currentLevel);
				gameOverSound.stop();
				backgroundSound.stop();
			} else if (mouse.isOverObject(gameOverExitImg)) {
				menuScene = new MenuScene();
				game.setNewGame();
				game.keyboard.removeKey(Keyboard.ENTER_KEY);
				game.transitTo(menuScene);
				gameOverSound.stop();
				backgroundSound.stop();
			}
		}
	}
	
	private void renderLifeBar() {
		lifeBar.width = (((Structure) playerImage).getHealth() * 200)/((Structure) playerImage).getMaxHealth();
		lifeBar.draw();
		if (((Structure) playerImage).getHealth() <= 0) {
			game.setIsGameOver();
		}
	}
	
	private void checkKeyboardPress() {
		if ( keyboard.keyDown(KeyEvent.VK_P)) {
			game.pressPause();
		}
	}

	private void checkShootPress() {
		int floor = 500;
		if (keyboard.keyDown(Keyboard.SPACE_KEY) && Player.getInstance().getGun().canShoot()) {
			if (game.getSoundStatus()) {
				new Sound("src/sounds/shoot_laser.wav").play();
				
				
			}
			bullet.addBullet(playerImage.x + playerImage.width/2, playerImage.y + playerImage.height/2, floor);
		}
		bullet.step(floor);
	}
	
/*	private void PlayBackgroundSound(Sound backgroundSound) {
		if (!backgroundSound.isExecuting()) {
			backgroundSound.play();
			System.out.println("Play sound");
		}
	}
*/
	private boolean isInside(Sprite sprite) {
		boolean isInside = sprite.x > -20 &&
				           sprite.x < WindowConstants.WIDTH + 20 &&
				           sprite.y > -300 &&
				           sprite.y < WindowConstants.HEIGHT + 20;
		
		return isInside;
	}
	
	public void update(){
		draw();
		checkKeyboardPress();
		
		if (!game.getIsPaused() && !game.getIsGameOver()) {	
			((Structure) playerImage).moveY(2.5);
			((Structure) playerImage).moveX(2.5);
			checkShootPress();
			if (fac.isSpawnTime()) {
				enemies.addAll(fac.factoryMethod());
			}
			
			// Enemy things
			Iterator<Enemy> itrEnemy = enemies.iterator();
			while (itrEnemy.hasNext()) {
				Enemy enemy = itrEnemy.next();
				
				enemy.move();
				
				if (!isInside(enemy)) {
					fac.sendBack(enemy);
					itrEnemy.remove();
					continue;
				}
				
				ArrayList<Bullet> bulletsToBeRemoved = new ArrayList<Bullet>();
				
				for (Bullet playerBullet : bullet.getBullets()) {
					if(Collision.collided(playerBullet, enemy)) {
						bulletsToBeRemoved.add(playerBullet);
						enemy.takeDamage(Player.getInstance().getGun().getShootDamage());
						gameScore.notifyObservers(enemy);
						scoreHigh.setScore(Score.score);
					}
				}
				bullet.removeBullets(bulletsToBeRemoved);
				
				if(Collision.collided(playerImage, enemy)) {
					((Structure) playerImage).takeDamage(1);
					enemy.takeDamage(1);
				}				
				if(enemy.isShooting()) {
					obstacles.add(enemy.shoot());
				}
				
				int enemyHealth = enemy.getHealth();
				
				if (enemyHealth <= 0) {
					try {
						fac.sendBack(enemy);
						itrEnemy.remove();
					} catch (Exception e) {
						System.out.println("Error when trying to remove an enemy");
					}
					continue;
				}
			}
			
			// Obstacle things
			Iterator<Obstacle> itrObs = obstacles.iterator();
			while (itrObs.hasNext()) {
				Obstacle obstacle = itrObs.next();
				
				obstacle.move();
				if(Collision.collided(playerImage, obstacle)) {
					((Structure) playerImage).takeDamage(obstacle.getDamage());
					itrObs.remove();
				}
				if(!isInside(obstacle)) {
					itrObs.remove();
				}
			}
	
		} else if (game.getIsPaused()) {
			drawPausedButtons();
			checkPausedMenuButtonsClick();
			
		} else if (game.getIsGameOver()) {
			if (game.getSoundStatus() && !gameOverSound.isExecuting()) {
				backgroundSound.stop();
				gameOverSound.play();
				
			}
			drawGameOverButtons();
			checkGameOverMenuButtonsClick();
			gameScore.clearScore();
		}
	}
}
