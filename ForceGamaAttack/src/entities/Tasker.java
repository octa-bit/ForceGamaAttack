package entities;
import java.lang.Math;

import constants.FileNames;
import score.Score;

public class Tasker extends Enemy {
		
	private int time = 0;
	private int reloadTime = 0;
	public static int health = 10;
	
	public Tasker (float x, float y) {
		super("src/graphics/img/sprites/TaskerSprite.png", 1, x, y, health);
		this.reset();
	}
	
	
	public void reset() {
		this.hitPoints = 10;
		this.value = 5;
		this.colisionDamage = 5;
	}
	
	
	public void move() {
		this.y += 1;
		this.x += Math.sin(Math.toRadians(time)) * 6;
		// Seno varia de 1 a -1 em um intervalo de 2pi
		// 2pi rads equivale a 360 time
		this.time += 3;
		// assumindo 30 iterações por segundo
		// temos que time+=180 por segundo
		// ou seja, time demora 2 segundos para alcançar 360
		// onde 1 segundo é indo pra direita
		// e 1 segundo é indo pra esquerda
		
		if (this.time >= 360) {
			this.time = 0;
		}
	}
	
	public boolean isShooting () {
		if (reloadTime >= 150) {
			reloadTime = 0;
			return true;
		}
		reloadTime++;
		return false;
	}
	
	
	public Obstacle shoot() {
		int bulletSpd = 3;
		int bulletDmg = 8;
		Obstacle obj = new Obstacle(FileNames.spritePath + "blueLaser.png", 1,
                this.x, this.y, bulletDmg, 0.0, (double) bulletSpd);
		return obj;
	}
}