package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import player.PowerUp;
import player.PowerUp.PowerUpType;

public class PowerUpFactoryPhase1 {
	private int time=3000;
	public List<PowerUp> powerUpList = new ArrayList<PowerUp>();

	public PowerUpFactoryPhase1() {
		for (int i=0; i<600; i+=50) {
			powerUpList.add(new PowerUp(i, 0, PowerUpType.HAPPINESS, "Happy", 248));
		}
	}
	
	public boolean isSpawnTime() {
		if (time < 3000) {
			 time++;
			return false;
		} else {
			time=0;
			return true;
		}
	}

	public PowerUp factoryMethod() {
		Random r = new Random();
		PowerUp pwr = powerUpList.get(r.nextInt(powerUpList.size()));
		
		return pwr;
	}
}
