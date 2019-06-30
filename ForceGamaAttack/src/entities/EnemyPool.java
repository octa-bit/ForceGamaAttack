package entities;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class EnemyPool {
	
	private List<Enemy> pool = new ArrayList<Enemy>();
	
	public EnemyPool() {}
	
	
	public EnemyPool(Enemy enemy) {
		this.add(enemy);
	}
	
	
	public EnemyPool(List<Enemy> enemies) {
		this.add(enemies);
	}
	
	
	public void add(Enemy enemy) {
		pool.add(enemy);
	}
	
	
	public void add(List<Enemy> enemies) {
		pool.addAll(enemies);
	}
	
	
	public void giveBack(Enemy enemy) {
		enemy.reset();
		System.out.println("received a " + enemy.getClass().getSimpleName());
		pool.add(enemy);
	}

	
	public List<Enemy> getEnemies(int quantity, int x, int y, int dist, String orientation) {
		List<Enemy> list = new ArrayList<Enemy>();
		
		if (quantity > pool.size()) {
			throw new UnsupportedOperationException("Insufficient Pool");
		}
		
		if (orientation == "vertical") orientation = "V";
		if (orientation == "horizontal") orientation = "H";
		
		if (orientation != "V" && orientation != "H") {
			throw new IllegalArgumentException("Orientation must be V ou H");
		}
		
		int i=0;
		Iterator<Enemy> itr = pool.iterator();

		if (orientation == "H") {
			while(itr.hasNext() && i < quantity) {
				Enemy enemy = itr.next();
				enemy.setX(x + dist*i);
				enemy.setY(y);
				list.add(enemy);
				itr.remove();
				i++;
			}
		} else {
			while(itr.hasNext() && i < quantity) {
				Enemy enemy = itr.next();
				enemy.setX(x);
				enemy.setY(y - dist*i);
				list.add(enemy);
				itr.remove();
				i++;
			}
		}
		
		System.out.println("sended " + quantity + "! Total on pool now: " + pool.size());
		return list;
	}
}

