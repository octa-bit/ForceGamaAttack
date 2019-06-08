package entities;
import java.lang.Math;

import score.Score;

public class Tasker extends Enemy {
		
	private int time = 0;
	
	public Tasker (float x, float y, Score score) {
		super(score, "TODO", 20, x, y);
		this.hitPoints = 10;
		this.value = 5;
		this.colisionDamage = 5;
	}
	
	public void move() {
		this.y += 1;
		this.x += Math.sin(Math.toRadians(time)) * 2;
		// Seno varia de 1 a -1 em um intervalo de 2pi
		// 2pi rads equivale a 360 time
		this.time += 6;
		// assumindo 30 iterações por segundo
		// temos que time+=180 por segundo
		// ou seja, time demora 2 segundos para alcançar 360
		// onde 1 segundo é indo pra direita
		// e 1 segundo é indo pra esquerda
		
		if (this.time >= 360) {
			this.time = 0;
		}
	}
	
}