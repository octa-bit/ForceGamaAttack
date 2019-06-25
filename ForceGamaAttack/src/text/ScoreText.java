package text;

import java.awt.Color;
import java.awt.Font;

import jplay.Time;

public class ScoreText extends Time {
	
	private int text;

	public ScoreText(int x, int y, Font font, Color color, int text) {
		super(0, 0, 0, x, y, font, color, true);
		this.text = text;
	}
	
//	public String toString() {
//		return this.score;
//	}
	
	public int toInt() {
		return this.text;
	}
}
