package gui.willhero;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class RedOrc extends Orc{

    private String color = "red";
    private static final long serialVersionUID = 41;

    RedOrc(int d, int hp, int disp, Node orcImg, Game game) {
        super(d, hp, disp, orcImg, game);
    }

    @Override
    public Node onCollision(ImageView helmet) {
        return null;
    }

}
