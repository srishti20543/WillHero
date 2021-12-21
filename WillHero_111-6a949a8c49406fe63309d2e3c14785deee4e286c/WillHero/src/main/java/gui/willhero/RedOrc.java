package gui.willhero;

import javafx.scene.image.ImageView;

public class RedOrc extends Orc{

    private String color = "red";

    RedOrc(int d, int hp, int disp) {
        super(d, hp, "red", disp);
    }

    @Override
    public void setHealth() {

    }

    @Override
    public void setDead() {

    }

    @Override
    public void getDead() {

    }

    @Override
    public int onCollision(ImageView helmet) {
        return -1;
    }
}
