package factoryEnemy;

import model.entity.enemy.Arachnik;
import model.entity.enemy.BlackDragon;
import model.entity.enemy.Dragon;
import model.entity.enemy.Enemy;
import model.entity.enemy.Slugger;
import model.tileMap.TileMap;

public class FactoryEnemy {
	public static final String ARACHNIK = "ARACHNIK";
	public static final String DRAGON = "DRAGON";
	public static final String SLUGGER = "SLUGGER";
	public static final String BLACKDRAGON = "BLACKDRAGON";

	public static Enemy get(String enemy, TileMap tm, int x, int y) {
		switch (enemy) {
		case ARACHNIK:
			return new Arachnik(tm, x, y);
		case DRAGON:
			return new Dragon(tm, x, y);
		case SLUGGER:
			return new Slugger(tm, x, y);
		case BLACKDRAGON:
			return new BlackDragon(tm, x, y);
		default:
			return null;
		}
	}
}
