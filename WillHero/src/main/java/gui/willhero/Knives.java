package gui.willhero;

import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Knives extends Weapons{

    private Node img;

    Knives(Node knife){
        super("Knives", 1);
        this.img = knife;
    }

    public void update(){
        super.update();
        img.setOpacity(0.0);
    }


    @Override
    public Node onCollision(ImageView helmet) {
        return null;
    }

    @Override
    public void use(){
        Image t1_img = new Image("ThrowingKnives.png");
        ImageView t1= new ImageView();
        t1.setImage(t1_img);
        t1.setFitWidth(40);
        t1.setFitHeight(7);
        t1.setLayoutX(getCurPlayer().getNode().getLayoutX());
        t1.setLayoutY(getCurPlayer().getNode().getLayoutY() + 15);
        img = t1;
        getGame().getGamePane().getChildren().add(t1);
        animations.throwKnife(t1);

    }


    @Override
    public void toggle(){
        animations.toggleOpacity((ImageView) img);
    }
    public void showSelected(){
        ScaleTransition st = new ScaleTransition(Duration.seconds(1), img);
        st.setByX(0.75);
        st.setByY(0.75);
        st.setCycleCount(2);
        st.setAutoReverse(true);
        st.play();
    }

    @Override
    public Node getImg(){
        return this.img;
    }


}
