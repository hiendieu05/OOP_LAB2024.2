package hust.oop.bomberman.entities.stillobject;

import hust.oop.bomberman.graphics.Sprite;

public class Wall extends StillObject {
    /**
     * Constructor of wall.
     */
    public Wall(int x, int y) {
        super(x, y, Sprite.wall.getFxImage(), null);
    }

    /**
     * This is update.
     */
    @Override
    public void update() {
    }
}
