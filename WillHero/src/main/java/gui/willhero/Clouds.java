package gui.willhero;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Random;

public class Clouds {

    transient Animations animations = new Animations();
    private final transient ArrayList<Node> clouds = new ArrayList<>();
    private static final long serialVersionUID = 10;

    public void addClouds(ImageView cloud){
        clouds.add(cloud);
        animations.moveCloud(cloud);
    }
}
