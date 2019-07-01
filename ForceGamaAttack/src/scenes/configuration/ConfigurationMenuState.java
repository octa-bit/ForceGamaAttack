package scenes.configuration;

import scenes.Scene;

public interface ConfigurationMenuState {
	void next(ConfigurationMenu menu);
    void prev(ConfigurationMenu menu);
    void printStatus();
    OptionMenu getOrdinal();
    Scene getScene();
}
