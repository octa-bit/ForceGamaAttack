package scenes.spaceShipMenu;

import scenes.Scene;

public class CShipState implements MenuState {

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
		return null;
	}

}
