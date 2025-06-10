package hust.oop.bomberman.entities.stillobject.item;

import hust.oop.bomberman.graphics.Sprite;
import hust.oop.bomberman.map_graph.Map;

public class FlameItem extends Item {

    /**
     * Constructor of flame item.
     */
    public FlameItem(int xUnit, int yUnit, Map map) {
        super(xUnit, yUnit, Sprite.powerup_flames.getFxImage(), map);
    }

}
