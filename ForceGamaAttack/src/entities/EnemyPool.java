package entities;

import java.util.List;
import java.util.ArrayList;

public class EnemyPool<Type> {
	
	
	private List<Type> pool = new ArrayList<Type>();
	private int useds = 0;
	private int firstAvailable = 0;

	
	public EnemyPool() {}

	
	public void add(Type enemy) {
		pool.add(enemy);
	}
	
	
	public void add(List<Type> enemies) {
		pool.addAll(enemies);
	}
	
	
	public void giveBack(Type enemy) {
		// reset status of enemy
	}
	
	
	private void incrementFirst() {
		firstAvailable = (firstAvailable + 1) % pool.size();
	}

	
	public List<Type> getFromType(int quantity) {
		List<Type> list = new ArrayList<Type>();
		
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

