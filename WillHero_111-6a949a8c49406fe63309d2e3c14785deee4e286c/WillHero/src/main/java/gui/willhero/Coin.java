package gui.willhero;

import javafx.scene.image.ImageView;

public class Coin extends GameObject{

    private int value;

    Coin(){
        value = 1;
    }

    @Override
    public int onCollision(ImageView helmet) {
        return -1;
    }
}
