package entities;

class Issuelizer extends Enemy {
	
	public Issuelizer (float x, float y) {
		super("src/graphics/img/sprites/IssuelizerSprite.png", 1, x, y);
		this.hitPoints = 10;
		this.value = 5;
		this.colisionDamage = 5;
	}
	
	public void move() {
		this.y += 0.6;
	}

}
