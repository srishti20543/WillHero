package gui.willhero;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Axe extends Weapons{

    private ImageView axe;
    private int level;

    Axe(Node axe){
        super("Axe", 10);
        level = 1;
        this.axe = (ImageView) axe;
    }

    @Override
    public void use() {

    }

    @Override
    public void toggle() {

    }

    @Override
    public Node onCollision(ImageView helmet) {
        return null;
    }
}
