package player;

import java.time.Duration;
import java.time.Instant;

public class Gun {
	int type;
	private int shootDamage;
	int shootingSpeed;
	int powerUp;
	private Instant lastShootTime;
	
	public Gun(int shootingSpeed, int shootDamage) {
		this.shootingSpeed = shootingSpeed;
		this.shootDamage = shootDamage;
		lastShootTime = Instant.now();
	}
	public void activePowerUp() {
	}

	public Instant getLastShootTime() {
		return lastShootTime;
	}

	public int getShootDamage() {
		return shootDamage;
	}
	
	public boolean canShoot() {
		Instant actualShoot = Instant.now();
		boolean canShoot = (Duration.between(lastShootTime, actualShoot).toMillis()) > shootingSpeed;
		if(canShoot) {
			lastShootTime = actualShoot;
		}
		return canShoot;
	}

	public void setLastShootTime(Instant time) {
		lastShootTime = time;
	}
}
