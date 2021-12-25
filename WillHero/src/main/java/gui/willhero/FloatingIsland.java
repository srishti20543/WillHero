package gui.willhero;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Random;

public class FloatingIsland extends GameObject{

    private Node island;
    private Node rectangle;

    FloatingIsland(Node island, Node rec){
        this.island = island;
        this.rectangle = rec;
        int x = new Random().nextInt(2);

        if(x == 0){
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
