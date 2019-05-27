package scenes.menu;

import scenes.Scene;

public class CreditState implements MenuState {

	@Override
	public void next(Menu menu) {
		menu.setState(new ExitState());
	}

	@Override
	public void prev(Menu menu) {
		menu.setState(new ConfigState());
	}

	@Override
	public void printStatus() {
		System.out.println("CreditState!");
	}
	
	@Override
	public OptionMenu getOrdinal() {
		return OptionMenu.Credit;
	}
	
	@Override
	public Scene getScene() {
		return null;
	}

}
