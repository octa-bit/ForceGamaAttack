package player;

public class StructureStrategyJava extends Structure {
	
	private Player player;
	double speed = 0.5;
	private static int javaHealth = 100;
	private final static String sprite = "src/graphics/img/java-ship.png";

	public StructureStrategyJava(int x, int y) {
		super(x, y, sprite, javaHealth);
		this.height = 90;
		this.width = 46;
		this.speed = 0.5;
	}
}
