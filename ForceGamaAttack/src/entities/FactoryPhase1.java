package entities;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import constants.WindowConstants;

public class FactoryPhase1 extends Factory {

	private int time=300;
	private EnemyPool taskerPool;
	private EnemyPool bugingPool;
	private EnemyPool issuelizerPool;
	
	public FactoryPhase1() {
		List<Enemy> taskerList = new ArrayList<Enemy>();
		for (int i=0; i<15; i++) {
			taskerList.add(new Tasker(0, 0));
		}
		this.taskerPool = new EnemyPool(taskerList);
		
		List<Enemy> issuelizerList = new ArrayList<Enemy>();
		for (int i=0; i<15; i++) {
			issuelizerList.add(new Issuelizer(0, 0));
		}
		this.issuelizerPool = new EnemyPool(issuelizerList);
		
		List<Enemy> bugingList = new ArrayList<Enemy>();
		for (int i=0; i<18; i++) {
			bugingList.add(new Buging(0, 0));
		}
		this.bugingPool = new EnemyPool(bugingList);
	}
	
	
	public void sendBack(Enemy enemy) {
		String name = enemy.getClass().getSimpleName();
		System.out.println(name);
		switch (name) {
		case "Tasker":
			taskerPool.giveBack(enemy);
			break;
		case "Issuelizer":
			issuelizerPool.giveBack(enemy);
			break;
		case "Buging":
			bugingPool.giveBack(enemy);
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	
	public boolean isSpawnTime() {
		if (time < 300) {
			 time++;
			return false;
		} else {
			time=0;
			return true;
		}
	}
	
	public List<Enemy> factoryMethod() {
		Random r = new Random();
		int sort = r.nextInt(11);
		List<Enemy> wave = new ArrayList<Enemy>();
		
		if (sort < 3) {
			int randPos = r.nextInt(350) + 20;
			wave.addAll(taskerPool.getEnemies(3, randPos, -50, 50, "horizontal"));
		    
		} else if (sort < 4) {
			int randPos = r.nextInt(300) + 20;
			wave.addAll(taskerPool.getEnemies(4, randPos, -50, 50, "horizontal"));

		} else if (sort < 7) {
			int randPos = r.nextInt(500) + 50;
			wave.addAll(issuelizerPool.getEnemies(3, randPos, -50, 60, "vertical"));
			
		} else if (sort < 9) {
			int randPos = r.nextInt(500) + 50;
			wave.addAll(issuelizerPool.getEnemies(4, randPos, -50, 60, "vertical"));
			
		} else if (sort < 10 ) {
			wave.addAll(bugingPool.getEnemies(3, -20, -20, 50, "horizontal"));
			wave.addAll(bugingPool.getEnemies(2, -20, 80, 50, "vertical"));
			
		} else {
			int limit = WindowConstants.WIDTH;
			wave.addAll(bugingPool.getEnemies(3, limit+20, -20, -50, "horizontal"));
			wave.addAll(bugingPool.getEnemies(2, limit+20, 80, 50, "vertical"));
			
		}
		
		return wave;
	}
}
