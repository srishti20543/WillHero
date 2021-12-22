package gui.willhero;

import javafx.scene.image.ImageView;

public class Sword extends Weapons{

    private ImageView img;

    Sword(){
        super("Sword", 20);
    }

    public void update(){
        super.update();
//        if ( getLevel() == 1){
//            animations.toggleOpacity(imgUI);
//        }
    }

    @Override
    public void addWep(ImageView swd) {
        img = swd;
    }


    @Override
    public int onCollision(ImageView helmet) {
        return 0;
    }

    @Override
    public void use(){
        animations.rotateWeapon(img, 360);
    }

    public void activate(){
        animations.toggleOpacity(img);
    }
}

