package hust.oop.bomberman.entities.stillobject;
import hust.oop.bomberman.graphics.Sprite;

public class Grass extends StillObject {
    /**
     * Constructor of grass.
     */
    public Grass(int x, int y) {
        super(x, y, Sprite.grass.getFxImage(), null);
    }

    /**
     * This is update.
     */
    @Override
    public void update() {
    }
}
