package gui.willhero;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Coin extends GameObject{

    private int value;
    private ArrayList<Node> coins = new ArrayList<>();

    Coin(){
        value = 1;
    }

    @Override
    public int onCollision(ImageView helmet) {
        for (Node coin : coins) {
            if (helmet.getBoundsInParent().intersects(coin.getBoundsInParent())) {
                animations.toggleOpacity((ImageView) coin);
                coins.remove(coin);
                return 1;
            }
        }
        return -1;
    }

    public void addCoins(ImageView c){
        coins.add(c);
    }
}
