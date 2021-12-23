package gui.willhero;

import javafx.scene.image.ImageView;

public class GreenOrc extends Orc{

    private String color = "green";

    GreenOrc(int d, int hp, int disp) {
        super(d, hp, "green", disp);
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
    public void addOrc(ImageView orc) {
    }

    @Override
    public void stayOnIsland(FloatingIsland islands) {

    }

    @Override
    public int onCollision(ImageView helmet) {
        return -1;
    }
}
