package factoryEnemy;

import model.entity.enemy.Enemy;
import model.tileMap.TileMap;

public interface IFactoryEnemy {
	public Enemy get(String type, TileMap tileMap, int x, int y);

}
