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

    private double openDy;
    private double closeDy;
    private Node prevo;
    private Node prevc;
    private Timeline chestGravity = new Timeline();

    Chest(Node open, Node close, Game game){
        this.open = open;
        this.close = close;
        this.game = game;

        KeyFrame chestG = new KeyFrame(Duration.millis(5), actionEvent -> {

            openDy = 1;
            closeDy = 1;

            Node no = game.checkCollisionIsland(open);
            Node nc = game.checkCollisionIsland(close);


            if(prevo == null){
                prevo = game.getPlatforms().get(0).getNode();
            }
            if(prevc == null){
                prevc = game.getPlatforms().get(0).getNode();
            }

            if(no!= null){
                prevo = no;
                openDy = -openDy;
            }

            if(nc != null){
                prevc = nc;
                closeDy = -closeDy;
            }

            open.setLayoutY(open.getLayoutY() + openDy);
            close.setLayoutY(close.getLayoutY() + closeDy);

        });

        chestGravity.getKeyFrames().add(chestG);
        chestGravity.setCycleCount(Timeline.INDEFINITE);
        chestGravity.play();
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
