package gui.willhero;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class FallingPlatform extends Obstacle{
    private Node rec;


    Timeline wait = new Timeline();

    FallingPlatform(Node rec){
        this.rec = rec;
        KeyFrame kf = new KeyFrame(Duration.millis(1), actionEvent -> {
            if(getCurPlayer().getNode().getBoundsInParent().intersects(rec.getBoundsInParent())){
//                animations.delay(750, rec);
                animations.fallPlat(rec);
                wait.stop();
            }
        });
        wait.getKeyFrames().add(kf);
        wait.setCycleCount(Timeline.INDEFINITE);
        wait.play();
    }

    public Node getNode(){
        return this.rec;
    }

}
