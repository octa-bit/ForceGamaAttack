package entities;

import score.Score;

public abstract class AbstractEnemyFactory {
	private static final Boss BOSS = new Boss(Score.INSTANCE);
	private static final Bug BUG = new Bug(Score.INSTANCE);
	private static final Issue ISSUE = new Issue(Score.INSTANCE);

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
