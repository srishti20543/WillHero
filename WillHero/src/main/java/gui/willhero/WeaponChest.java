package gui.willhero;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class WeaponChest extends Chest{

    private ArrayList<Node> weaponChestClosed = new ArrayList<Node>();
    private ArrayList<Node> weaponChestOpen = new ArrayList<Node>();

    private Weapons weapon;

    @Override
    public int onCollision(ImageView helmet) {
        for(int i = 0; i< weaponChestClosed.size(); i++){
            if (helmet.getBoundsInParent().intersects(weaponChestClosed.get(i).getBoundsInParent())) {
                animations.toggleOpacity((ImageView) weaponChestOpen.get(i));
                animations.toggleOpacity((ImageView) weaponChestClosed.get(i));
                weaponChestClosed.remove(weaponChestClosed.get(i));
                return generateWeapon();
            }
        }
        return -1;
    }

    public int generateWeapon(){
        return new Random().nextInt(2) ;
    }

    @Override
    public void addChest(ImageView closed, ImageView open) {
        weaponChestClosed.add(closed);
        weaponChestOpen.add(open);
    }

    public Weapons getWeapon(){
        return weapon;
    }
}
