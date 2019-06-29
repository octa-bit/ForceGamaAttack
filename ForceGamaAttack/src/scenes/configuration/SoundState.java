package scenes.configuration;

import scenes.Scene;

public class SoundState implements ConfigurationMenuState {
	
	@Override
	public void next(ConfigurationMenu menu) {
		menu.setState(new KeyboardState());
	}

	@Override
	public void prev(ConfigurationMenu menu) {
		menu.setState(new SoundState());
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
		ConfigurationScene configurationScene = new ConfigurationScene();
		return configurationScene;
	}
}
