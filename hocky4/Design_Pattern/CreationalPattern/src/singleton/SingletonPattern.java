package singleton;

public class SingletonPattern {
	// mẫu cơ bản
	private volatile static SingletonPattern instance = new SingletonPattern();

	private SingletonPattern() {
	}

	public static SingletonPattern getInstance() {
		if (instance == null) {
			synchronized (SingletonPattern.class) {
				if (instance == null) {
					instance = new SingletonPattern();
				}
			}
		}
		return instance;
	}

}
