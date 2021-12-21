package gui.willhero;

import javafx.scene.image.ImageView;

import java.util.Random;

public class CoinChest extends Chest{

    private int coinCount;
    private Coin coins;

    @Override
    public int onCollision(ImageView helmet) {
        return -1;
    }

    public void generateCoinCount(){
        coinCount = (int) (Math.random() * (10 - 2 + 1) + 2);
    }
}
