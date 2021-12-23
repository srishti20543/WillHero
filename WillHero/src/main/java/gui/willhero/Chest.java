package gui.willhero;

import javafx.scene.image.ImageView;

abstract class Chest extends GameObject{

    public abstract void addChest(ImageView closed, ImageView open);
    public abstract void stayOnIsland(FloatingIsland islands);
}
