package gui.willhero;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Axe extends Weapons{

    private ArrayList<Node> OrcAxe = new ArrayList<>();
    private int level;

    Axe(){
        super("Axe", 10, 1, true);
        level = 1;
    }

    @Override
    public void setLevel() {
        level++;
    }

    @Override
    public void addWep(ImageView axe){
        OrcAxe.add(axe);
    }
}
