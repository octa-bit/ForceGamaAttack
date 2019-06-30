package player;

public class StructureStrategyC extends player.Structure {

	private Player player;
	private static int cHealth = 50;
	private final static String sprite = "src/graphics/img/spaceship.png";

	public StructureStrategyC(int x, int y) {
		super(x, y, sprite, cHealth);
		this.height = 46;
		this.width = 18;
		this.speed = 2.0;
	}
}
