package entities;

import java.util.ArrayList;
import java.util.List;
import Observer.Observer;
import jplay.Sprite;
import score.Score;

public abstract class AbstractEnemyFactory {
	private static Score score;
	private static final Boss BOSS = new Boss(score);
	private static final Bug BUG = new Bug(score);
	private static final Issue ISSUE = new Issue(score);

	public static AbstractEnemy getFactory(EnemyType type) {
		AbstractEnemy enemy = null;
		switch (type) {
		case BOSS:
			System.out.println("BOSS");
			enemy = BOSS;
			break;
		case BUG:
			System.out.println("BUG");
			enemy = BUG;
			break;
		case ISSUE:
			System.out.println("ISSUE");
			enemy = ISSUE;
			break;
		}
		return enemy;
	}
}
