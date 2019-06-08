package player;

public class StructureStrategyJava extends Player {
	
	private Player player;
	double speed;
	private final static String sprite = "src/graphics/img/spaceshipJava.png";

	public StructureStrategyJava(int x, int y) {
		super(x, y, sprite);
	}
	
	public void move() {
		player.moveY(this.speed/2.0);
		player.moveX(this.speed/2.0);
	}
}
