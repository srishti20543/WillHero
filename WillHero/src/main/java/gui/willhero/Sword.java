package gui.willhero;

import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Sword extends Weapons{

    private Node img;

    Sword(Node sword){
        super("Sword", 20);
        this.img = sword;

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
        animations.rotateWeapon((ImageView) img, 360);
    }

    @Override
    public void toggle(){
        System.out.println(img.getId());
        animations.toggleOpacity((ImageView) this.img);
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

