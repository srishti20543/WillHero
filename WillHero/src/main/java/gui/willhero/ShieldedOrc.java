package gui.willhero;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class ShieldedOrc extends RedOrc{

    private ArrayList<Node> redOrc = new ArrayList<>();

    ShieldedOrc(int d, int hp, int disp, Node orcImg, Game game) {
        super(d, hp, disp, orcImg, game);
    }


    @Override
    public void addOrc(ImageView orc){
        redOrc.add(orc);
    }

    @Override
    public void stayOnIsland(FloatingIsland islands) {
        for(int i = 0; i< redOrc.size(); i++){
            Node orc = redOrc.get(i);
//            if(islands.onCollision((ImageView) orc) == -1){
//                orc.setTranslateY(orc.getTranslateY() + 1);
//            }
//            if(islands.onCollision((ImageView) orc) == 1){
//                orc.setTranslateY(orc.getTranslateY() - 1);
//            }
        }
    }
}
