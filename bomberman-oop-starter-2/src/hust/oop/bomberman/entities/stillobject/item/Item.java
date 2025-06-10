package hust.oop.bomberman.entities.stillobject.item;

import javafx.scene.image.Image;
import hust.oop.bomberman.entities.stillobject.StillObject;
import hust.oop.bomberman.map_graph.Map;

public abstract class Item extends StillObject  {
    /**
     * Constructor for item.
     */
    public Item(int xUnit, int yUnit, Image img, Map map) {
        super(xUnit, yUnit, img, map);
    }

    /**
     * Update items.
     */
    @Override
    public void update() {

    }
}
