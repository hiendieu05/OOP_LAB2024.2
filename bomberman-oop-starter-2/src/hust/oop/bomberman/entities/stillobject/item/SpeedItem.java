package hust.oop.bomberman.entities.stillobject.item;

import hust.oop.bomberman.graphics.Sprite;
import hust.oop.bomberman.map_graph.Map;

public class SpeedItem extends Item {
    /**
     * Constructor of speed item.
     */
    public SpeedItem(int xUnit, int yUnit, Map map) {
        super(xUnit, yUnit, Sprite.powerup_speed.getFxImage(), map);
    }
}
