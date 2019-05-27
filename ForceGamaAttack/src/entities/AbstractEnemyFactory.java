package entities;

import java.util.ArrayList;
import java.util.List;
import Observer.Observer;
import jplay.Sprite;
import score.Score;

public abstract class AbstractEnemyFactory extends Sprite{
	private int health;
	private int shootDamage;
	private int healthDamage;
	private int points;
	private static Score score;
	private static final Boss BOSS = new Boss(score);
	private static final Bug BUG = new Bug(score);
	private static final Issue ISSUE = new Issue(score);
	
	private float positionX;
	private float positionY;
	private int hitPoints;
	
	public int value;
	private int time = 0;
	private static String sprite = "";
	
	private List<Observer> observers = new ArrayList<Observer>();
	
	
	public AbstractEnemyFactory(int health, int shootDamage, int healthDamage, int points) {
		super(sprite, 10);
		this.health = health;
		this.shootDamage = shootDamage;
		this.healthDamage = healthDamage;
		this.points = points;
	}
	
	public AbstractEnemyFactory(Score score, String sprite, int size) {
		super(sprite, size);
		this.attach(score);
	}

	public static AbstractEnemyFactory getFactory(EnemyType type) {
		AbstractEnemyFactory enemy = null;
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
	
	public void attach(Observer obs) {
		this.observers.add(obs);
	}
	
	public void deattach(Observer obs) {
		this.observers.remove(obs);
	}
	
	void getHit(int dmg) {}
	void die() {}
	public void move() {}
	void shoot() {}
}
