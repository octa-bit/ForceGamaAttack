package enemy;
import java.lang.Math;
import score.Score;

public class TaskerEnemy extends Enemy {
	
	private int colisionDamage = 5;
	
	private int time = 0;
	
	public TaskerEnemy (int x, int y, Score score) {
		super(score);
		this.positionX = x;
		this.positionY = y;
		this.hitPoints = 10;
		this.value = 5;
	}
	
	public void move() {
		this.positionY += 2;
		this.positionX += Math.sin(Math.toRadians(time));
		// Seno varia de 1 a -1 em um intervalo de 2pi
		// 2pi rads equivale a 360 time
		this.time += 3;
		// assumindo 30 iterações por segundo
		// temos que time+=90 por segundo
		// ou seja, time demora 4 segundos para alcançar 360
		// onde 2 segundos são indo pra direita
		// e 2 segundos são indo pra esquerda
		
		if (this.time >= 360) {
			this.time = 0;
		}
	}
	
}
