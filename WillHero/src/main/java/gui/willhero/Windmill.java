package gui.willhero;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Windmill extends GameObject{

    private final transient ArrayList<Node> windmills = new ArrayList<>();
    private static final long serialVersionUID = 61;

    public void addWindmills(ImageView wm){
        windmills.add(wm);
        animations.fanRotate(wm);
    }

    @Override
    public Node onCollision(ImageView helmet) {
        return null;
    }

}
