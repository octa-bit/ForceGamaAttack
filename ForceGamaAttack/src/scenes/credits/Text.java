package scenes.credits;

import java.awt.Color;
import java.awt.Font;

import jplay.Time;

public class Text extends Time {
	
	private String text;

	public Text(int x, int y, Font font, Color color, String text) {
		super(0, 0, 0, x, y, font, color, true);
		this.text = text;
	}
	
	public String toString() {
		super.toString();
		return this.text;
	}

}
