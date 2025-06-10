package hust.oop.bomberman.entities.stillobject.item;

import hust.oop.bomberman.graphics.Sprite;
import hust.oop.bomberman.map_graph.Map;

public class BombItem extends Item {

    /**
     * Constructor of bomb item.
     */
    public BombItem(int xUnit, int yUnit, Map map) {
        super(xUnit, yUnit, Sprite.powerup_bombs.getFxImage(), map);
    }

}
