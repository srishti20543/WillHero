package gui.willhero;

import javafx.scene.image.ImageView;

public class Obstacle extends GameObject{

    @Override
    public int onCollision(ImageView helmet) {
        return -1;
    }
}
