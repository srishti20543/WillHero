package gui.willhero;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

abstract class Chest extends GameObject{

    private Node open;
    private Node close;
    private Game game;

    private boolean isOpen = false;
    private Node no;
    private Node nc;

    private final Timeline chestGravity = new Timeline();
    private final Timeline stayIsland = new Timeline();

    Chest(Node open, Node close, Game game){
        this.open = open;
        this.close = close;
        this.game = game;

        no = game.getPlatforms().get(0).getNode();
        nc = game.getPlatforms().get(0).getNode();

        KeyFrame chestG = new KeyFrame(Duration.millis(1), actionEvent -> {
            open.setLayoutY(open.getLayoutY() + 1);
            close.setLayoutY(close.getLayoutY() + 1);

            no = game.checkCollisionIsland(open);
            nc = game.checkCollisionIsland(close);

            if(no != null && nc != null){
                chestGravity.stop();
                stayIsland.play();
            }
        });

        chestGravity.getKeyFrames().add(chestG);
        chestGravity.setCycleCount(Timeline.INDEFINITE);
        chestGravity.play();

        KeyFrame stay = new KeyFrame(Duration.millis(1), actionEvent -> {
            open.setLayoutY(no.getLayoutY() - 36 + no.getTranslateY());
            close.setLayoutY(nc.getLayoutY() - 36 + + nc.getTranslateY());
        });

        stayIsland.getKeyFrames().add(stay);
        stayIsland.setCycleCount(Timeline.INDEFINITE);
    }

    public Node getNode(){
        return close;
    }

    public void openIt(){
        isOpen = true;
        animations.toggleOpacity((ImageView) close);
        animations.toggleOpacity((ImageView) open);
    }

    public boolean getIfopen(){
        return this.isOpen;
    }
}
