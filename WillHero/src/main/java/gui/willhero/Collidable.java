package gui.willhero;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

public interface Collidable {

    public Node onCollision(ImageView helmet);
}
