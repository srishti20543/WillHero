package gui.willhero;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Coin extends GameObject{

    private int value;
    private transient Node coinImg;
    private static final long serialVersionUID = 2;

    Coin(ImageView img){
        value = 1;
        coinImg = img;
    }

    @Override
    public Node onCollision(ImageView helmet) {
        return null;
    }

    public Node getNode(){
        return this.coinImg;
    }
}
