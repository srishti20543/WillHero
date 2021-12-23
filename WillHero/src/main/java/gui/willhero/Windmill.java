package gui.willhero;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Windmill extends GameObject{

    private final ArrayList<Node> windmills = new ArrayList<>();

    public void addWindmills(ImageView wm){
        windmills.add(wm);
        animations.fanRotate(wm);
    }

    @Override
    public int onCollision(ImageView helmet) {
        return 0;
    }

}
