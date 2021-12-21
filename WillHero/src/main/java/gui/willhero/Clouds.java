package gui.willhero;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Random;

public class Clouds extends GameObject {

    private final ArrayList<Node> clouds = new ArrayList<>();

    public void addClouds(ImageView cloud){
        clouds.add(cloud);
        animations.moveCloud(cloud);
    }

    @Override
    public int onCollision(ImageView helmet) {
        return -1;
    }
}
