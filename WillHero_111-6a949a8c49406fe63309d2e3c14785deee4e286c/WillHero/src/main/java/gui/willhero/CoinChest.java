package gui.willhero;

import java.util.Random;

public class CoinChest extends Chest{

    private int coinCount;
    private Coin coins;

    @Override
    public void onCollision(User user) {

    }

    public void generateCoinCount(){
        coinCount = (int) (Math.random() * (10 - 2 + 1) + 2);
    }
}
