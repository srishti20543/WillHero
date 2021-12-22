package gui.willhero;

import javafx.scene.image.ImageView;

public class Knives extends Weapons{

    private ImageView img;

    Knives(){
        super("Knives", 10);
    }

    public void update(){
        super.update();
//        if ( getLevel() == 1){
//            animations.toggleOpacity(img);
//        }
    }

    @Override
    public void addWep(ImageView knife) {
        img = knife;
    }


    @Override
    public int onCollision(ImageView helmet) {
        return 0;
    }

    @Override
    public void use(){
        animations.throwKnife(img);
    }

    public void activate(){
        animations.toggleOpacity(img);
    }

    public ImageView getImg(){
        return this.img;
    }


}
