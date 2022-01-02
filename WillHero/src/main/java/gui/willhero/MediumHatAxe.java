package gui.willhero;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.util.Duration;

public class MediumHatAxe extends GreenOrc{

    private Axe axe;
    private transient Timeline die = new Timeline();
    private static final long serialVersionUID = 421;



    MediumHatAxe(Node orcImg,Axe axe, Game game) {
        super(10, 100, 25, orcImg, game);
        this.axe = axe;

        KeyFrame d = new KeyFrame(Duration.millis(1), actionEvent -> {
            if(this.getHealth() <= 0){
                axe.disable();
                die.stop();
            }
        });

        die.getKeyFrames().add(d);
        die.setCycleCount(Timeline.INDEFINITE);
        die.play();
    }



}
