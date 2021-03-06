package scenes.spaceShipMenu;

import player.Gun;
import player.Structure;
import player.StructureStrategyJava;
import player.StructureStrategyPython;
import scenes.Scene;
import scenes.credits.CreditsScene;
import scenes.game.GameScene;

public class PythonShipState implements MenuState {
	private static Scene startLevel;

	@Override
	public void next(Menu menu) {
		menu.setState(new JavaShipState());
	}

	@Override
	public void prev(Menu menu) {
		menu.setState(new CShipState());
	}

	@Override
	public void printStatus() {
		System.out.println("Python Ship!");
	}
	
	@Override
	public OptionMenu getOrdinal() {
		return OptionMenu.Python;
	}
	
	@Override
	public Scene getScene() {
		Structure structure = new StructureStrategyPython(400, 300);
		Gun gun = new Gun(structure.getGunShootingSpeed(), structure.getGunDamage());
		startLevel = new GameScene(structure, gun);
		return startLevel;
	}

}
