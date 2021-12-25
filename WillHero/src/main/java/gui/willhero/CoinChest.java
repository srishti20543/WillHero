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

    CoinChest(Node cco, Node ccc, Game game){
        super(cco, ccc, game);
    }

    @Override
    public Node onCollision(ImageView helmet) {
        return null;
    }

    public int generateCoinCount(){
        this.coinCount = (int) (Math.random() * (10 - 2 + 1) + 2);
        return coinCount;
    }



}
