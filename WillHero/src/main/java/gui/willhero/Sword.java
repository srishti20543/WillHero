package gui.willhero;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class Sword extends Weapons{

    private ImageView img;

    Sword(){
        super("Sword", 20);
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
        animations.rotateWeapon(img, 360);
    }

    @Override
    public void toggle(){
        animations.toggleOpacity(img);
    }

}

