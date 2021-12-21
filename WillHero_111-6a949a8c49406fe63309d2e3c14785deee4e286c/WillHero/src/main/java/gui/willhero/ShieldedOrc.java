package gui.willhero;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class ShieldedOrc extends RedOrc{

    private ArrayList<Node> redOrc = new ArrayList<>();

    ShieldedOrc() {
        super(10, 50, 4);
    }

    @Override
    public void addOrc(ImageView orc){
        redOrc.add(orc);
    }
}
