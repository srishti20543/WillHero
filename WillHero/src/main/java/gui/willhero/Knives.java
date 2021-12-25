package gui.willhero;

import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Knives extends Weapons{

    private Node img;

    Knives(Node knife){
        super("Knives", 10);
        this.img = knife;

    }

    public void update(){
        super.update();
    }


    @Override
    public Node onCollision(ImageView helmet) {
        return null;
    }

    @Override
    public void use(){
        animations.throwKnife((ImageView) img);
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

    public Node getImg(){
        return this.img;
    }


}
