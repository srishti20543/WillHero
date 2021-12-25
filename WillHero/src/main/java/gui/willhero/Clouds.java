package gui.willhero;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Random;

public class Clouds {

    Animations animations = new Animations();

    private final ArrayList<Node> clouds = new ArrayList<>();

    public void addClouds(ImageView cloud){
        clouds.add(cloud);
        animations.moveCloud(cloud);
    }
}
