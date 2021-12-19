package gui.willhero;

import java.util.ArrayList;

public class Helmet extends GameObject{

    private String name;
    private ArrayList<Weapons> weaponsOfHelmet;

    Helmet(String name){
        this.name = name;
    }

    @Override
    public void onCollision(User user) {

    }
}
