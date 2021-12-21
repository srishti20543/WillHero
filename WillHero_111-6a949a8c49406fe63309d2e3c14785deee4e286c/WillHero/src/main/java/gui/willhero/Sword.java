package gui.willhero;

import javafx.scene.image.ImageView;

public class Sword extends Weapons{

    private ImageView img;

    Sword(){
        super("Sword", 20);
    }

    public void update(){
        super.update();
        if ( getLevel() == 1){
            animations.toggleOpacity(img);
        }
    }

    @Override
    public void addWep(ImageView swd) {
        img = swd;
    }

    @Override
    public int onCollision(ImageView helmet) {
        return 0;
    }
}

