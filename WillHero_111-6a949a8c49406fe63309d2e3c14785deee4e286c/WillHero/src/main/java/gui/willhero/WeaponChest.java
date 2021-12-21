package gui.willhero;

import javafx.scene.image.ImageView;

public class WeaponChest extends Chest{

    private Weapons weapon;
    @Override
    public int onCollision(ImageView helmet) {
        return -1;
    }

    public void generateWeapon(){
        int random = (int) (Math.random() * (2) + 1);
        if(random == 1){
            weapon = new Knives();
        }
        else if(random == 2){
            weapon = new Sword();
        }
    }
}
