package gui.willhero;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class Knives extends Weapons{

    private ImageView img;

    Knives(){
        super("Knives", 10);
    }

    public void update(){
        super.update();
    }

    @Override
    public void addWep(ImageView knife) {
        img = knife;
    }


    @Override
    public Node onCollision(ImageView helmet) {
        return null;
    }

    @Override
    public void use(){
        animations.throwKnife(img);
    }

    @Override
    public void toggle(){
        animations.toggleOpacity(img);
    }

    public ImageView getImg(){
        return this.img;
    }


}
