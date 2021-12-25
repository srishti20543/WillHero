package gui.willhero;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class CoinChest extends Chest{

    private int coinCount;
    private Coin coins;
    private ImageView ccc;
    private ImageView cco;

    CoinChest(Node ccc, Node cco){
        this.ccc = (ImageView) ccc;
        this.cco = (ImageView) cco;
    }

    @Override
    public Node onCollision(ImageView helmet) {
        return null;
    }

    public void generateCoinCount(){
        this.coinCount = (int) (Math.random() * (10 - 2 + 1) + 2);
    }

}
