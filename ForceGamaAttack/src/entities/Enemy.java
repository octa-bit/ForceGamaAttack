package entities;

public class Enemy {
	private int health;
	private int shootDamage;
	private int healthDamage;
	private int points;

	public Enemy() {
		this.health = 0;
		this.shootDamage = 0;
		this.healthDamage = 0;
		this.points = 0;
	}
	
	public Enemy(int health, int shootDamage, int healthDamage, int points) {
		this.health = health;
		this.shootDamage = shootDamage;
		this.healthDamage = healthDamage;
		this.points = points;
	}
	
	void shoot() {
		// TODO;
	}
}
