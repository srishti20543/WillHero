package gui.willhero;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class MediumHatAxe extends GreenOrc{
    private ArrayList<Node> gOrc = new ArrayList<>();

    MediumHatAxe() {
        super(15, 50, 4);
    }

    public void attack(User user){

    }

    @Override
    public void addOrc(ImageView orc){
        gOrc.add(orc);
    }
}
