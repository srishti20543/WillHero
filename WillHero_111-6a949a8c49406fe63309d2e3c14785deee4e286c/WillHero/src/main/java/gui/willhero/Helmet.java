package gui.willhero;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Helmet extends GameObject{

    private String name;
    private ArrayList<Weapons> weaponsOfHelmet;

    Helmet(String name){
        this.name = name;
    }

    @Override
    public int onCollision(ImageView helmet) {
        return -1;
    }
}
