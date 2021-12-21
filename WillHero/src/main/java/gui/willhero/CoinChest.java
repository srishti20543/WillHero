package gui.willhero;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class CoinChest extends Chest{

    private int coinCount;
    private Coin coins;
    private ArrayList<Node> coinChestClosed = new ArrayList<Node>();
    private ArrayList<Node> coinChestOpen = new ArrayList<Node>();

    @Override
    public int onCollision(ImageView helmet) {
        for(int i = 0; i< coinChestClosed.size(); i++){
            if (helmet.getBoundsInParent().intersects(coinChestClosed.get(i).getBoundsInParent())) {
                animations.toggleOpacity((ImageView) coinChestOpen.get(i));
                animations.toggleOpacity((ImageView) coinChestClosed.get(i));
                coinChestClosed.remove(coinChestClosed.get(i));
                generateCoinCount();
                return coinCount;
            }
        }
        return -1;
    }

    public void generateCoinCount(){
        this.coinCount = (int) (Math.random() * (10 - 2 + 1) + 2);
    }

    @Override
    public void addChest(ImageView closed, ImageView open){
        coinChestClosed.add(closed);
        coinChestOpen.add(open);
    }
}
