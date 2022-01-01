package gui.willhero;

import javafx.geometry.Point2D;

import java.io.Serializable;

abstract class GameObject implements Serializable, Collidable {

    private static long serialVersionUID;
    private static User curPlayer;
    private static Game game;
    Animations animations = new Animations();

    public static Game getGame() {
        return game;
    }

    public static void setGame(Game game){
        GameObject.game = game;
    }

    public static void setUser(User user) {
        GameObject.curPlayer = user;
    }
    public static User getCurPlayer(){
        return GameObject.curPlayer;
    }
}

