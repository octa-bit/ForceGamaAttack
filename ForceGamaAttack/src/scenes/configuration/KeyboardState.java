package scenes.configuration;

import scenes.Scene;
import scenes.keyboard.KeyboardScene;

public class KeyboardState implements ConfigurationMenuState {
	KeyboardScene keyboardScene;
	
	@Override
	public void next(ConfigurationMenu menu) {
		menu.setState(new SoundState());
	}

	@Override
	public void prev(ConfigurationMenu menu) {
		menu.setState(new KeyboardState());
	}

	@Override
	public void printStatus() {
		System.out.println("KeyboardState!");
	}
	
	@Override
	public OptionMenu getOrdinal() {
		return OptionMenu.Keyboard;
	}
	
	@Override
	public Scene getScene() {
		keyboardScene = new KeyboardScene();
		return keyboardScene;
	}
}
