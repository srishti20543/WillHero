package gui.willhero;

import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Random;

public class FloatingIsland extends GameObject{

    private transient Node island;
    private transient Node rectangle;
    private static final long serialVersionUID = 51;

    Timeline floating = new Timeline();

    FloatingIsland(Node island, Node rec){
        this.island = island;
        this.rectangle = rec;
        this.rectangle.setOpacity(0.0);
        int animationType = new Random().nextInt(2);

        if(animationType == 0){
            animations.floatingUp((Rectangle) rec);
            animations.floatingUp((ImageView) island);
        }
        else{
            animations.floatingDown((Rectangle) rec);
            animations.floatingDown((ImageView) island);
        }

    }

    @Override
    public Node onCollision(ImageView helmet) {
        return null;
    }

    public Node getNode(){
        return this.rectangle;
    }
}
