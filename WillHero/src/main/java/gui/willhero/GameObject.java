package gui.willhero;

import javafx.geometry.Point2D;

import java.io.Serializable;

abstract class GameObject implements Serializable, Collidable {

    private static long serialVersionUID;

    Animations animations = new Animations();

//    private Point2D gameObjVelocity = new Point2D(0, 0);
//
//    public void checkCollisionwithPlatform(FloatingIsland island){
//        if (gameObjVelocity.getY() < 10) {
//            gameObjVelocity = gameObjVelocity.add(0, 1);
//        }
//
//        moveObjectY((int)gameObjVelocity.getY(), island);
//    }
//
//    public void moveObjectY(int value, FloatingIsland island){
//        for (int i = 0; i < Math.abs(value); i++){
//
//        }
//    }
}
