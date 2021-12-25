package gui.willhero;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Axe extends Weapons{

    private Node axe;
    private int level;

    Axe(Node axe){
        super("Axe", 10);
        level = 1;
        this.axe = axe;
    }

    @Override
    public void use() {
        return;
    }

    @Override
    public void toggle() {

    }

    @Override
    public Node getImg() {
        return axe;
    }

    @Override
    public Node onCollision(ImageView helmet) {
        return null;
    }
}
