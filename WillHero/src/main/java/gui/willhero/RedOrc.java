package gui.willhero;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class RedOrc extends Orc{

    private String color = "red";

    RedOrc(int d, int hp, int disp, Node orcImg, Game game) {
        super(d, hp, disp, orcImg, game);
    }


    @Override
    public void setHealth() {

    }

    @Override
    public void setDead() {

    }

    @Override
    public void getDead() {

    }

    @Override
    public Node onCollision(ImageView helmet) {
        return null;
    }

}
