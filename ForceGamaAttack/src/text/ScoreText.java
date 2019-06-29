package text;

import java.awt.Color;
import java.awt.Font;

import jplay.Time;

public class ScoreText extends Time {
	
	private int score = 0;

	public ScoreText(int x, int y, Font font, Color color) {
		super(0, 0, 0, x, y, font, color, true);
	}
	
	
	public String toString() {
		super.toString();
		return Integer.toString(this.score);
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}