package gui.willhero;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class GreenOrc extends Orc{

    private String color = "green";

    GreenOrc(int d, int hp, int disp, Node orcImg, Game game) {
        super(d, hp, disp, orcImg, game);
    }

    @Override
    public Node onCollision(ImageView helmet) {
        return null;
    }
}
