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

    @Override
    public void stayOnIsland(FloatingIsland islands) {
        for(int i = 0; i< gOrc.size(); i++){
            Node orc = gOrc.get(i);
            if(islands.onCollision((ImageView) orc) == -1){
                orc.setTranslateY(orc.getTranslateY() + 1);
            }
            if(islands.onCollision((ImageView) orc) == 1){
                orc.setTranslateY(orc.getTranslateY() - 1);
            }
        }
    }
}
