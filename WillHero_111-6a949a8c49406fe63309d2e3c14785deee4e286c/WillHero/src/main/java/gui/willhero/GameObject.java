package gui.willhero;

import java.io.Serializable;

abstract class GameObject implements Serializable, Collidable {

    private Position pos;
    private static long serialVersionUID;

    Animations animations = new Animations();

    public Position getPosition(){
        return pos;
    }

    public void setPosition(){

    }
}
