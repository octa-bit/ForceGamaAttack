package player;
import jplay.Keyboard;

import jplay.Sprite;	

public class Player extends Sprite{
	private Player player;
	double speed;
	public Structure structure;
	static String sprite = "src/graphics/img/spaceship.png";
	private Keyboard keyboard;
	
	private static final Player INSTANCE = new Player(360, 550, sprite);
	
	public Player(int x, int y, String sprite) {	
		super(sprite, 10);
		this.x = x;
		this.y = y;
	}
	
	public static Player getInstance() {
		return INSTANCE;
	}

	public Keyboard getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(Keyboard keyboard) {
		this.keyboard = keyboard;
	}

	public Structure getStructure() {
		return structure;
	}

	public void setStructure(Structure structure) {
		this.structure = structure;
	}
	
}
