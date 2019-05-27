package scenes.menu;

import scenes.Scene;

public class ConfigState implements MenuState {

	@Override
	public void next(Menu menu) {
		menu.setState(new CreditState());
	}

	@Override
	public void prev(Menu menu) {
		menu.setState(new StartState());
	}

	@Override
	public void printStatus() {
		System.out.println("ConfigState!");
	}
	
	@Override
	public OptionMenu getOrdinal() {
		return OptionMenu.Config;
	}
	
	@Override
	public Scene getScene() {
		return null;
	}

}
