package Observer;
import entities.Enemy;

public abstract class Observer {
	public abstract void notifier(Enemy boss);
	public abstract void notifyObservers();
    public abstract void addObserver(Observer o);
    public abstract void removeObserver(Observer o);
}
