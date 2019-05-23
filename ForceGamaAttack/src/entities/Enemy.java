package entities;

enum Type {
    BOSS, BUG, ISSUE
}

abstract class AbstractEnemyFactory {
	private int health;
	private int shootDamage;
	private int healthDamage;
	private int points;
	
	private static final Boss BOSS = new Boss();
	private static final Bug BUG = new Bug();
	private static final Issue ISSUE = new Issue();
	
	public AbstractEnemyFactory() {
		this.health = 0;
		this.shootDamage = 0;
		this.healthDamage = 0;
		this.points = 0;
	}
	
	public AbstractEnemyFactory(int health, int shootDamage, int healthDamage, int points) {
		this.health = health;
		this.shootDamage = shootDamage;
		this.healthDamage = healthDamage;
		this.points = points;
	}
	
	static AbstractEnemyFactory getFactory(Type type) {
		AbstractEnemyFactory enemy = null;
        switch (type) {
            case BOSS:
                enemy = BOSS;
                break;
            case BUG:
                enemy = BUG;
                break;
            case ISSUE:
                enemy = ISSUE;
                break;
        }
        return enemy;
    }
	
	void shoot() {
		// TODO;
	}
}
