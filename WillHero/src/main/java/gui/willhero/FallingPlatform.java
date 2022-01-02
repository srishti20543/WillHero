package gui.willhero;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;

public class FallingPlatform extends Obstacle{

    private ArrayList<Node> recs = new ArrayList<>();


    Timeline wait = new Timeline();

    FallingPlatform(Node rec1, Node rec2,Node rec3, Node rec4, Node rec5){
        recs.add(rec1);
        recs.add(rec2);
        recs.add(rec3);
        recs.add(rec4);
        recs.add(rec5);

        KeyFrame kf = new KeyFrame(Duration.millis(1), actionEvent -> {
            for(Node rec : recs){
                if(getCurPlayer().getNode().getBoundsInParent().intersects(rec.getBoundsInParent())){
                    animations.fallPlat(recs);
                    wait.stop();
                    break;
                }
            }

        });
        wait.getKeyFrames().add(kf);
        wait.setCycleCount(Timeline.INDEFINITE);
        wait.play();
    }

    public ArrayList<Node> getNode(){
        return this.recs;
    }

    public Node checkCollision(Node node){
        for(Node rec : recs){
            if(node.getBoundsInParent().intersects(rec.getBoundsInParent())){
                animations.fallPlat(recs);
                return rec;
            }
        }
        return null;
    }

}
