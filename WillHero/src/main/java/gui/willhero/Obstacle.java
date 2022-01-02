package gui.willhero;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class Obstacle extends GameObject{

    private static final long serialVersionUID = 6;

    @Override
    public Node onCollision(ImageView helmet) {
        return null;
    }
}
