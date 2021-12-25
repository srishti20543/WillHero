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

    private double openDy = 0.05;
    private double closeDy = 0.05;
    private Node no;
    private Node nc;

    private Timeline chestGravity = new Timeline();

    Chest(Node open, Node close, Game game){
        this.open = open;
        this.close = close;
        this.game = game;

        no = game.getPlatforms().get(0).getNode();
        nc = game.getPlatforms().get(0).getNode();

        KeyFrame chestG = new KeyFrame(Duration.millis(10), actionEvent -> {
            open.setLayoutY(open.getLayoutY() + openDy);
            close.setLayoutY(close.getLayoutY() + closeDy);

            no = game.checkCollisionIsland(open);
            nc = game.checkCollisionIsland(close);

            if(no != null || nc != null){
                chestGravity.stop();
            }
        });

        chestGravity.getKeyFrames().add(chestG);
        chestGravity.setCycleCount(Timeline.INDEFINITE);
        chestGravity.play();

        String id = no.getId();
        System.out.println(id);
        int ind = Integer.parseInt(String.valueOf(id.charAt(id.length() - 1)));
        int type = game.getPlatforms().get(ind - 1).getAnimationType();

        if(type == 0){
            animations.floatingUp((ImageView) open);
            animations.floatingUp((ImageView) close);
        }
        else{
            animations.floatingDown((ImageView) open);
            animations.floatingDown((ImageView) close);
        }
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
