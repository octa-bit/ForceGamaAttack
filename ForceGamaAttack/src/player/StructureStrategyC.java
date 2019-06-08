package player;

public class StructureStrategyC extends Player {
	
	private Player player;
	double speed;
	private final static String sprite = "src/graphics/img/spaceshipC.png";

	public StructureStrategyC(int x, int y) {
		super(x, y, sprite);
	}
	
	public void move() {
		player.moveY(this.speed*1.5);
		player.moveX(this.speed*1.5);
	}
}
