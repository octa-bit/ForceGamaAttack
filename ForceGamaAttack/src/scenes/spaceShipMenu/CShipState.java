package scenes.spaceShipMenu;

import player.Gun;
import player.Structure;
import player.StructureStrategyC;
import player.StructureStrategyJava;
import player.StructureStrategyPython;
import scenes.Scene;
import scenes.game.GameScene;

public class CShipState implements MenuState {
	private static Scene startLevel;

	@Override
	public void next(Menu menu) {
		menu.setState(new PythonShipState());
	}

	@Override
	public void prev(Menu menu) {
		menu.setState(new JavaShipState());
	}

	@Override
	public void printStatus() {
		System.out.println("C Ship!");
	}
	
	@Override
	public OptionMenu getOrdinal() {
		return OptionMenu.C;
	}
	
	@Override
	public Scene getScene() {
		Structure structure = new StructureStrategyC(400, 300);
		Gun gun = new Gun(structure.getGunShootingSpeed(), structure.getGunDamage());
		startLevel = new GameScene(structure, gun);
		return startLevel;
	}

}
