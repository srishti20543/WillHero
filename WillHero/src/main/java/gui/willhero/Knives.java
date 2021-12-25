package gui.willhero;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

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

    public Node getImg(){
        return this.img;
    }


}
