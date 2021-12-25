package gui.willhero;

import javafx.geometry.Point2D;

import java.io.Serializable;

abstract class GameObject implements Serializable, Collidable {

    private static long serialVersionUID;
    Animations animations = new Animations();
}
