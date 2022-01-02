package gui.willhero;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;

public class FallingPlatform extends Obstacle{

    private final transient ArrayList<Node> recs = new ArrayList<>();
    private static final long serialVersionUID = 5;


    FallingPlatform(Node rec1, Node rec2,Node rec3, Node rec4, Node rec5){
        recs.add(rec1);
        recs.add(rec2);
        recs.add(rec3);
        recs.add(rec4);
        recs.add(rec5);
    }

    public ArrayList<Node> getNode(){
        return this.recs;
    }

    public Node checkCollision(Node node){
        for(Node rec : recs){
            if(node.getBoundsInParent().intersects(rec.getBoundsInParent())){
                animations.delay(500, recs);
                return rec;
            }
        }
        return null;
    }

}
