package scenes.configuration;

import scenes.Scene;

public class SoundState implements ConfigurationMenuState {
	ConfigurationScene configurationScene;
	
	@Override
	public void next(ConfigurationMenu menu) {
		menu.setState(new KeyboardState());
	}

	@Override
	public void prev(ConfigurationMenu menu) {
		menu.setState(new KeyboardState());
	}

	@Override
	public void printStatus() {
		System.out.println("SoundState!");
	}
	
	@Override
	public OptionMenu getOrdinal() {
		return OptionMenu.Sound;
	}
	
	@Override
	public Scene getScene() {
		configurationScene = new ConfigurationScene();
		return configurationScene;
	}
}
