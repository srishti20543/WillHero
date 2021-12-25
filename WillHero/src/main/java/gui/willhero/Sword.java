package gui.willhero;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

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
        animations.toggleOpacity((ImageView) img);
    }

    public Node getImg(){
        return this.img;
    }
}

