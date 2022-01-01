package gui.willhero;

import javafx.animation.*;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Animations {

    private boolean isRotating = false;
    private boolean isThrowing = false;

    public void floatingDown(ImageView island) {
        TranslateTransition floating = new TranslateTransition();
        floating.setDuration(Duration.seconds(10));
        floating.setToY(island.getY() + 8);
        floating.setAutoReverse(true);
        floating.setCycleCount(Animation.INDEFINITE);
        floating.setNode(island);
        floating.play();
    }

    public void floatingDown(Rectangle rec) {
        TranslateTransition floating = new TranslateTransition();
        floating.setDuration(Duration.seconds(10));
        floating.setToY(rec.getY() + 8);
        floating.setAutoReverse(true);
        floating.setCycleCount(Animation.INDEFINITE);
        floating.setNode(rec);
        floating.play();
    }

    public void floatingUp(ImageView island) {
        TranslateTransition floating = new TranslateTransition();
        floating.setDuration(Duration.seconds(10));
        floating.setToY(island.getY() - 8);
        floating.setAutoReverse(true);
        floating.setCycleCount(Animation.INDEFINITE);
        floating.setNode(island);
        floating.play();
    }

    public void floatingUp(Rectangle rec) {
        TranslateTransition floating = new TranslateTransition();
        floating.setDuration(Duration.seconds(10));
        floating.setToY(rec.getY() - 8);
        floating.setAutoReverse(true);
        floating.setCycleCount(Animation.INDEFINITE);
        floating.setNode(rec);
        floating.play();
    }

    public void fanRotate(ImageView wm) {
        RotateTransition rt = new RotateTransition();
        rt.setDuration(Duration.seconds(5));
        rt.setToAngle(360);
        rt.setCycleCount(Animation.INDEFINITE);
        rt.setInterpolator(Interpolator.LINEAR);
        rt.setNode(wm);
        rt.play();
    }

    public void moveCloud(ImageView cloud) {
        TranslateTransition floating = new TranslateTransition();
        floating.setDuration(Duration.seconds(150));
        floating.setToX(cloud.getX() - 1000);
        floating.setCycleCount(Animation.INDEFINITE);
        floating.setNode(cloud);
        floating.play();
    }

    public void throwKnife(ImageView knife) {
        KeyFrame k = new KeyFrame(Duration.millis(1), actionEvent -> {
            knife.setLayoutX(knife.getLayoutX() + 0.5);
        });
        Timeline t = new Timeline();
        t.getKeyFrames().add(k);
        t.setCycleCount(1000);
        t.setOnFinished(actionEvent -> {
            knife.setOpacity(0.0);
            knife.setDisable(true);
        });
        t.play();
    }


    public void rotateWeapon(ImageView weapon, double angle) {
        if (!isRotating) {
            isRotating = true;
            RotateTransition rotate = new RotateTransition();
            rotate.setNode(weapon);
            rotate.setDuration(Duration.millis(200));
            rotate.setInterpolator(Interpolator.LINEAR);
            rotate.setCycleCount(2);
            rotate.setAutoReverse(true);
            rotate.setByAngle(angle);
            rotate.setOnFinished(actionEvent -> isRotating = false);
            rotate.play();
        }

    }

    public void toggleOpacity(ImageView img) {
        if (img.getOpacity() == 0.0) {
            img.setDisable(false);
            img.setOpacity(1.0);
        } else {
            img.setDisable(true);
            img.setOpacity(0.0);
        }
    }
}


