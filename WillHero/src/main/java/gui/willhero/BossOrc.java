package gui.willhero;

import javafx.scene.Node;

import java.util.ArrayList;

public class BossOrc extends RedOrc{
    private ArrayList<Weapons> weaponsList;

    BossOrc(int d, int hp, int disp, Node orcImg, Game game) {
        super(d, hp, disp, orcImg, game);
    }

    public void attack(User user){

    }
}
