package hust.oop.bomberman.entities.stillobject;

import javafx.scene.image.Image;
import hust.oop.bomberman.entities.Entity;
import hust.oop.bomberman.map_graph.Map;

public abstract class StillObject extends Entity {
    protected Map map;
    /**
     * Constructor for still object.
     */
    public StillObject(int xUnit, int yUnit, Image img, Map map) {
        super(xUnit, yUnit, img);
        this.map = map;
    }
}
