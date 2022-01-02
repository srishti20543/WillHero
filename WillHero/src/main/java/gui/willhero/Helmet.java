package gui.willhero;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public abstract class Helmet extends GameObject{

    private String name;
    private ArrayList<Weapons> weaponsOfHelmet;
    private static final long serialVersionUID = 7;

    Helmet(String name){
        this.name = name;
    }

    @Override
    public Node onCollision(ImageView helmet) {
        return null;
    }

    public abstract ImageView getImg();
}
