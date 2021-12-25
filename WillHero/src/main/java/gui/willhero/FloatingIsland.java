package gui.willhero;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Random;

public class FloatingIsland extends GameObject{

    private final ArrayList<Node> islands = new ArrayList<>();
    private final ArrayList<Node> rectangles = new ArrayList<>();

    @Override
    public Node onCollision(ImageView helmet) {
        for (Node platform : rectangles) {
            if (helmet.getBoundsInParent().intersects(platform.getBoundsInParent())) {
                return platform;
            }
        }
        return null;
    }

    public void addPlatform(ImageView island, Rectangle rec){
        islands.add(island);
        rec.setOpacity(0.0);
        rectangles.add(rec);

        int x = new Random().nextInt(2);

        if(x == 0){
            animations.floatingUp(rec);
            animations.floatingUp(island);
        }
        else{
            animations.floatingDown(rec);
            animations.floatingDown(island);
        }
    }

    public ArrayList<Node> getRectangles() {
        return rectangles;
    }
}
