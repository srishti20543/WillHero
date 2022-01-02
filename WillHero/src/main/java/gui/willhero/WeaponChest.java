package gui.willhero;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class WeaponChest extends Chest{

    private static final long serialVersionUID = 32;

    WeaponChest(Node wco, Node wcc, Game game){
        super(wco, wcc, game);
    }


    public int generateWeapon() {
        return new Random().nextInt(2) ;
    }

    @Override
    public Node onCollision(ImageView helmet) {
        return null;
    }
}
