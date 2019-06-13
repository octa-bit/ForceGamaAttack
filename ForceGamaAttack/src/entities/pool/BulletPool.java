package entities.pool;

import entities.Bullet;
import entities.BulletManager;


public class BulletPool extends ObjectPool<BulletManager>{

	@Override
	protected BulletManager create() {
		BulletManager bullet = new BulletManager();
		return bullet;
	}
	
}
