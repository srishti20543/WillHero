package gui.willhero;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class CoinChest extends Chest{

    private Coin coins;
    private transient ImageView ccc;
    private transient ImageView cco;
    private static final long serialVersionUID = 31;

    CoinChest(Node cco, Node ccc, Game game){
        super(cco, ccc, game);
    }

    @Override
    public Node onCollision(ImageView helmet) {
        return null;
    }

    public int generateCoinCount(){
        return (int) (Math.random() * (10 - 2 + 1) + 2);
    }



}
