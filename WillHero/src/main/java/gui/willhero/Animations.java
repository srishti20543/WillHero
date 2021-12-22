package gui.willhero;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Animations {

    public void floatingDown(ImageView island){
        TranslateTransition floating = new TranslateTransition();
        floating.setDuration(Duration.seconds(10));
        floating.setToY(island.getY() + 10);
        floating.setAutoReverse(true);
        floating.setCycleCount(Animation.INDEFINITE);
        floating.setNode(island);
        floating.play();
    }
    public void floatingDown(Rectangle rec){
        TranslateTransition floating = new TranslateTransition();
        floating.setDuration(Duration.seconds(10));
        floating.setToY(rec.getY() + 10);
        floating.setAutoReverse(true);
        floating.setCycleCount(Animation.INDEFINITE);
        floating.setNode(rec);
        floating.play();
    }

    public void floatingUp(ImageView island){
        TranslateTransition floating = new TranslateTransition();
        floating.setDuration(Duration.seconds(10));
        floating.setToY(island.getY() - 10);
        floating.setAutoReverse(true);
        floating.setCycleCount(Animation.INDEFINITE);
        floating.setNode(island);
        floating.play();
    }

    public void floatingUp(Rectangle rec){
        TranslateTransition floating = new TranslateTransition();
        floating.setDuration(Duration.seconds(10));
        floating.setToY(rec.getY() - 10);
        floating.setAutoReverse(true);
        floating.setCycleCount(Animation.INDEFINITE);
        floating.setNode(rec);
        floating.play();
    }

    public void fanRotate(ImageView wm){

        RotateTransition rt = new RotateTransition();
        rt.setDuration(Duration.seconds(5));
        rt.setToAngle(360);
        rt.setCycleCount(Animation.INDEFINITE);
        rt.setInterpolator(Interpolator.LINEAR);
        rt.setNode(wm);
        rt.play();
    }

    public void moveCloud(ImageView cloud){
        TranslateTransition floating = new TranslateTransition();
        floating.setDuration(Duration.seconds(150));
        floating.setToX(cloud.getX() - 1000);
        floating.setCycleCount(Animation.INDEFINITE);
        floating.setNode(cloud);
        floating.play();
    }

    public void throwKnife(ImageView knife){

        double pos = knife.getX();
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(knife);
        translate.setDuration(Duration.millis(750));
        translate.setByX(pos + 300);
        translate.play();
        knife.setX(pos);
    }

    public void rotateWeapon(ImageView weapon, double angle){
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(weapon);
        rotate.setDuration(Duration.millis(500));
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setAutoReverse(true);
        rotate.setByAngle(angle);
        rotate.play();
    }

    public void OrcJump(ImageView orc){
        TranslateTransition jmp = new TranslateTransition();
        jmp.setDuration(Duration.seconds(1.5));
        jmp.setToY(orc.getY() - 20);
        jmp.setAutoReverse(true);
        jmp.setCycleCount(Animation.INDEFINITE);
        jmp.setNode(orc);
        jmp.play();
    }

    public void toggleOpacity(ImageView img){
        if(img.getOpacity() == 0.0){
            img.setOpacity(1.0);
        }
        else{
            img.setOpacity(0.0);
        }
    }
}
