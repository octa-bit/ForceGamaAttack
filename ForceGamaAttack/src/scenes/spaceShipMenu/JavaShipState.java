package scenes.spaceShipMenu;

import player.Gun;
import player.Structure;
import player.StructureStrategyJava;
import player.StructureStrategyPython;
import scenes.Scene;
import scenes.game.GameScene;

public class JavaShipState implements MenuState {
	private static Scene startLevel;

	@Override
	public void next(Menu menu) {
		menu.setState(new CShipState());
	}

	@Override
	public void prev(Menu menu) {
		menu.setState(new PythonShipState());
	}

	@Override
	public void printStatus() {
		System.out.println("Java Ship!");
	}

	@Override
	public OptionMenu getOrdinal() {
		return OptionMenu.Java;
	}

	@Override
	public Scene getScene() {
		Structure structure = new StructureStrategyJava(400, 300);
		Gun gun = new Gun(structure.getGunShootingSpeed(), structure.getGunDamage());
		startLevel = new GameScene(structure, gun);
		return startLevel;
	}

}
