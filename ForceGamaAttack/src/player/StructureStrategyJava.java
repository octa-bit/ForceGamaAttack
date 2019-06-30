package player;

public class StructureStrategyJava extends Structure {
	
	private Player player;
	private static int javaHealth = 100;
	private final static String sprite = "src/graphics/img/java-ship.png";

	public StructureStrategyJava(int x, int y) {
		super(x, y, sprite, javaHealth);
		this.height = 40;
		this.width = 46;
		this.speed = 0.5;
	}
}
