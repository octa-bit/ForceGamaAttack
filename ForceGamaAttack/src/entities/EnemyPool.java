package entities;

import java.util.List;
import java.util.ArrayList;

public class EnemyPool {
	
	private List<Enemy> pool = new ArrayList<Enemy>();
	private int useds = 0;
	private int firstAvailable = 0;

	
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
		this.useds -= 1;
	}
	
	
	private void incrementFirst() {
		firstAvailable = (firstAvailable + 1) % pool.size();
	}

	
	public List<Enemy> getFromEnemy(int quantity) {
		List<Enemy> list = new ArrayList<Enemy>();
		
		if (useds >= pool.size() || quantity > pool.size() - useds) {
			throw new UnsupportedOperationException("Empty pool");
		}
		
		for (int i=0; i<quantity; i++) {
			list.add(pool.get(firstAvailable));
			incrementFirst();
		}
		
		useds += quantity;
		
		return list;
	}
}

